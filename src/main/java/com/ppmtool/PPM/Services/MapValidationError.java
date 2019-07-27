package com.ppmtool.PPM.Services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapValidationError {

    public ResponseEntity<?> mapValidationError(BindingResult bindingResult){

        if(bindingResult.hasErrors())
        {

            Map<String,String> errorMap=new HashMap<>();

            for(FieldError field:bindingResult.getFieldErrors()){

                errorMap.put(field.getField(),field.getDefaultMessage());

            }

            return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        return null;
    }
}
