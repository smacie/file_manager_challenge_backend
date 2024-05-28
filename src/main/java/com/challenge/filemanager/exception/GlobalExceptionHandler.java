package com.challenge.filemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import java.io.FileNotFoundException;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public ResponseEntity<Object> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException exception) {
        return ResponseEntity
                .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                .body(exception.getMessage());
    }
    @ExceptionHandler({MissingServletRequestPartException.class})
    public ResponseEntity<Object> handleMissingServletRequestPartException(MissingServletRequestPartException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }

    @ExceptionHandler({FileNotFoundException.class})
    public ResponseEntity<Object> handleFileNotFoundException(FileNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler({IOException.class})
    public ResponseEntity<Object> handleIOException(IOException exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }
}
