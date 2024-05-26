package gabs.desafio_pic_pay.controllers.exceptions;

import gabs.desafio_pic_pay.exceptions.PicPayException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestHandlerExptionDetails {

    @ExceptionHandler(PicPayException.class)
    public ProblemDetail toProblemDetail(PicPayException e) {
        return e.toProblemDetail();
    }
}
