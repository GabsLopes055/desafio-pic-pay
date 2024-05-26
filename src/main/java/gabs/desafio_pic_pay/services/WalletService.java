package gabs.desafio_pic_pay.services;

import gabs.desafio_pic_pay.DTOs.WalletRequest;
import gabs.desafio_pic_pay.entity.Wallet;
import gabs.desafio_pic_pay.exceptions.WalletDataExistsException;
import gabs.desafio_pic_pay.repository.WalletRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletService {

    private final WalletRepository repository;

    public WalletService(WalletRepository repository) {
        this.repository = repository;
    }

    public Wallet createWallet(WalletRequest request) {

        var existWallet = repository.findBycpfCnpjOrEmail(request.cpfCnpj(), request.email());

        if(existWallet.isPresent()) {
            throw new WalletDataExistsException("Cpf/Cnpf ou Email já existem cadastrados");
        }

        return repository.save(request.ToWallet());

    }
}
