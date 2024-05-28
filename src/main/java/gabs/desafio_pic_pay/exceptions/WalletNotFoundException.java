package gabs.desafio_pic_pay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletNotFoundException extends PicPayException {

    private Long walletId;

    public WalletNotFoundException(Long wallet) {
        this.walletId = wallet;
    }

    @Override
    public ProblemDetail toProblemDetail() {

        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        problemDetail.setTitle("Wallet não encontrada");
        problemDetail.setDetail("Não foi encontrado nenhuma carteira para o id: " + walletId);

        return problemDetail;

    }
}
