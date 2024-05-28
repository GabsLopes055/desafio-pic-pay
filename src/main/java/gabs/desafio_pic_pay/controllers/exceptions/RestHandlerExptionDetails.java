package gabs.desafio_pic_pay.controllers.exceptions;

import gabs.desafio_pic_pay.exceptions.PicPayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class RestHandlerExptionDetails {

    @ExceptionHandler(PicPayException.class)
    public ProblemDetail toProblemDetail(PicPayException e) {
        return e.toProblemDetail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        List<String> listErros = exception.getFieldErrors().stream().map(fieldError -> "Parametro Inválido: " + fieldError.getField() + ". Mensagem: " + fieldError.getDefaultMessage()).toList();

        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        problemDetail.setTitle("Parametro invalido na requisição");
        problemDetail.setProperty("parametros invalidos", listErros);

        return problemDetail;
    }
}
