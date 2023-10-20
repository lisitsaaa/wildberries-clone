package com.example.wildberriesclone.service.util;

import com.example.wildberriesclone.exception.InvalidDataException;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

public final class Validator {
    public static void checkBindingResult(BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors()
                    .forEach(fieldError -> errors.put(fieldError.getField(), fieldError.getDefaultMessage()));
            throw new InvalidDataException(String.valueOf(errors));
        }
    }
}
