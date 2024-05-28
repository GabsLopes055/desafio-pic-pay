package gabs.desafio_pic_pay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransferNotAllowerForWalletTypeException extends PicPayException {

    @Override
    public ProblemDetail toProblemDetail() {

        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        problemDetail.setTitle("Transferencia não permitida para esse tipo de carteira.");

        return problemDetail;

    }
}
