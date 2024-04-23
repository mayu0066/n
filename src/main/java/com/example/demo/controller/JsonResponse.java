package com.example.demo.controller;

import java.util.List;

import org.springframework.validation.ObjectError;

import lombok.Data;

@Data
public class JsonResponse {

    private boolean hasError = false;
    
    private List<ObjectError> errors;
    
    private Object data;
    
    
    public JsonResponse() {
        
    }
    
    
    public JsonResponse(List<ObjectError> errors) {
        this.hasError = true;
        this.errors = errors;
    }
    
    public JsonResponse(Object data) {
        this.data = data;
    }
}
