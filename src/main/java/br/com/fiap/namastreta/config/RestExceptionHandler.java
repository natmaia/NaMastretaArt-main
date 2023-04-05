package br.com.fiap.namastreta.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.fiap.namastreta.exception.RestNotFoundException;
import br.com.fiap.namastreta.models.RestValidationError;

@RestControllerAdvice
public class RestExceptionHandler {

    Logger log = LoggerFactory.getLogger(getClass());
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<RestValidationError>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        log.error("erro de validacao");
        List<RestValidationError> errors = new ArrayList<>();
        e.getFieldErrors().forEach(v -> errors.add(new RestValidationError(v.getField(), v.getDefaultMessage())));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(RestNotFoundException.class)
    public ResponseEntity<RestValidationError> RestNotFoundExceptionHandler(RestNotFoundException e){
        log.error("erro de validacao");
       
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RestValidationError(null, e.getMessage()));
    }

    


// Aqui vc determina a mensagem de cada exception

        // RestNotFoundException("Artista não encontrado"));


}
