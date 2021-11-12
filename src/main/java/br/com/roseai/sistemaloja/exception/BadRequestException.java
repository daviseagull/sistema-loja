package br.com.roseai.sistemaloja.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    private final String message;

    public BadRequestException(String message) {
        super(message);
        this.message = message;
    }
}
