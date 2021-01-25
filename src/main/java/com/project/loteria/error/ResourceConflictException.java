package com.project.loteria.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceConflictException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    public ResourceConflictException(String mensagem) {
        super(mensagem);
 }
}