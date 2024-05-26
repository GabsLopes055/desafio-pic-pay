package gabs.desafio_pic_pay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletDataExistsException extends PicPayException{

    String detail;

    public WalletDataExistsException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {

        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        problemDetail.setTitle("Wallet já existe cadastrada");

        problemDetail.setDetail(detail);

        return problemDetail;
    }

}
