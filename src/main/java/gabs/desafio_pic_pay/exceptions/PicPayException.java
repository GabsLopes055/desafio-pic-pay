package gabs.desafio_pic_pay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class PicPayException extends RuntimeException{

    public ProblemDetail toProblemDetail() {

        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        problemDetail.setTitle("PicPay - Erro interno do servidor");

        return problemDetail;
    }

}
