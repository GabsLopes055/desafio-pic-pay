package gabs.desafio_pic_pay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class UnauthorizedTransferForPayer extends PicPayException {

    @Override
    public ProblemDetail toProblemDetail() {

        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNAUTHORIZED);

        problemDetail.setTitle("Transação não autorizada");
        problemDetail.setDetail("Não é permitido enviar transações para propria conta");

        return problemDetail;

    }
}
