package gabs.desafio_pic_pay.exceptions;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import java.math.BigDecimal;

public class SaldoInsuficienteException extends PicPayException {

    BigDecimal value;

    public SaldoInsuficienteException(BigDecimal value) {
        this.value = value;
    }

    @Override
    public ProblemDetail toProblemDetail() {

        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problemDetail.setTitle("Saldo insuficiente");
        problemDetail.setDetail("O valor da transferencia ( R$:  " + value + " ) é maior do que o saldo em conta.");

        return problemDetail;
    }
}
