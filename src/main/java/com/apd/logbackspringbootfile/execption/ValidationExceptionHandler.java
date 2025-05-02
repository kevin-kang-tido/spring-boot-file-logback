package com.apd.logbackspringbootfile.execption;

import com.apd.logbackspringbootfile.base.BasedError;
import com.apd.logbackspringbootfile.base.BasedErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    BasedErrorResponse handleValidationError(MethodArgumentNotValidException e){

        // GET : error message
        String errors = e.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining("; "));

        BasedError<Object> basedError = BasedError.builder()
                .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .description(errors)
                .timeStamp(LocalDateTime.now().toString())
                .build();
        return new BasedErrorResponse(basedError);
    }

}