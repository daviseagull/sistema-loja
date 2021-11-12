package br.com.roseai.sistemaloja.config.error;

import br.com.roseai.sistemaloja.exception.EmptyOptionalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@Slf4j
@RestControllerAdvice
public class EmptyOptionalExceptionHandler {

    @ExceptionHandler(EmptyOptionalException.class)
    public ResponseEntity<Map<String, String>> feignEmptyOptionalErrorHandler(EmptyOptionalException ex) {
        log.error("EmptyOptionalException handler: ", ex);
        var responseError = Map.of("Mensagem de erro", ex.getMessage());
        return status(OK).body(responseError);
    }
}
