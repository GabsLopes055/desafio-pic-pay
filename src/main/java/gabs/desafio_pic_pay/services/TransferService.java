package gabs.desafio_pic_pay.services;

import gabs.desafio_pic_pay.DTOs.TransferRequest;
import gabs.desafio_pic_pay.entity.Transfer;
import gabs.desafio_pic_pay.entity.Wallet;
import gabs.desafio_pic_pay.exceptions.*;
import gabs.desafio_pic_pay.repository.TranfersRepository;
import gabs.desafio_pic_pay.repository.WalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TransferService {

    private final TranfersRepository tranfersRepository;
    private final NotificationService notification;
    private final AuthorizationService authorization;
    private final WalletRepository walletRepository;

    public TransferService(TranfersRepository tranfersRepository, NotificationService notification, AuthorizationService authorization, WalletRepository walletRepository) {
        this.tranfersRepository = tranfersRepository;
        this.walletRepository = walletRepository;
        this.notification = notification;
        this.authorization = authorization;
    }

    @Transactional
    public Transfer transfer(TransferRequest transferRequest) {

        var sender = walletRepository.findById(transferRequest.payer()).orElseThrow(() -> new WalletNotFoundException(transferRequest.payer()));
        var receiver = walletRepository.findById(transferRequest.payee()).orElseThrow(() -> new WalletNotFoundException(transferRequest.payee()));

        validateTransfer(transferRequest, sender);

        sender.debit(transferRequest.value());
        receiver.credit(transferRequest.value());

        Transfer transfer =  new Transfer(sender, receiver, transferRequest.value());


        walletRepository.save(sender);
        walletRepository.save(receiver);

        Transfer transferResult = tranfersRepository.save(transfer);

        CompletableFuture.runAsync(() -> notification.setNotificationClient(transferResult));

        return transferResult;

    }

    private void validateTransfer(TransferRequest transferRequest, Wallet sender) {

        if(!sender.isTransferAllowedForWalletType()) {
            throw new TransferNotAllowerForWalletTypeException();
        }

        if(!sender.valorTransferencia(transferRequest.value())) {
            throw new SaldoInsuficienteException(transferRequest.value());
        }

        if(!authorization.isAuthorized()) {
            throw new TransferNotAuthorizedException();
        }

        if(transferRequest.payer().equals(transferRequest.payee())) {
            throw new UnauthorizedTransferForPayer();
        }


    }
}
