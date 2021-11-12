package br.com.roseai.sistemaloja.config.error;

import br.com.roseai.sistemaloja.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.ResponseEntity.status;

@Slf4j
@RestControllerAdvice
public class BadRequestErrorHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Map<String, String>> feignBadRequestErrorHandler(BadRequestException ex) {
        log.error("BadRequestException handler: ", ex);
        var responseError = Map.of("Mensagem de erro", ex.getMessage());
        return status(BAD_REQUEST).body(responseError);
    }

}
