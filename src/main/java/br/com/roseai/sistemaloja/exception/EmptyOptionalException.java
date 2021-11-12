package br.com.roseai.sistemaloja.exception;

public class EmptyOptionalException extends RuntimeException {

    private final String message;

    public EmptyOptionalException(String message) {
        super(message);
        this.message = message;
    }

}
