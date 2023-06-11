package com.essam.student.management.exceptions;

import com.essam.student.management.response.ApiResponse;
import jakarta.validation.ConstraintViolationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BaseExceptionHandler {

    private static Logger logger = LogManager.getLogger(BaseExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
                    if (errors.containsKey(error.getField())) {
                        errors.put(error.getField(), String.format("%s, %s", errors.get(error.getField()), error.getDefaultMessage()));
                    } else {
                        errors.put(error.getField(), error.getDefaultMessage());
                    }
                }
        );
        return ApiResponse.validationError("VALIDATION_FAILED", "VALIDATION_FAILED", errors);
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ApiResponse accessDeniedExceptionHandler(AccessDeniedException ex) {
        logger.error(ex);
        return new ApiResponse(403, HttpStatus.FORBIDDEN.toString(), "common.security.forbidden", ex.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse genericExceptionHandler(Exception ex) {
        logger.error(ex);
        ex.printStackTrace();
        if (ex instanceof MethodArgumentNotValidException) {
            StringBuilder errors = new StringBuilder();
            for (ObjectError error : ((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors()) {
                errors.append(error.getDefaultMessage() + "   AND   ");
            }
            return new ApiResponse(500, HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Error, internal server error", errors);
        } else {
            return new ApiResponse(500, HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Error, internal server error", ex.getMessage());
        }
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse badRequestExceptionHandler(ConstraintViolationException ex) {
        logger.error(ex);
        return new ApiResponse(400, HttpStatus.BAD_REQUEST.toString(), "Error, Bad Request", ex.getMessage());
    }

}
