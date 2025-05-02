package com.apd.logbackspringbootfile.execption;

import com.apd.logbackspringbootfile.base.BasedError;
import com.apd.logbackspringbootfile.base.BasedErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class MethodNotSupportHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    BasedErrorResponse methodNotSupport(HttpRequestMethodNotSupportedException e){

        String method = e.getMethod();

        String supportedMethods = String.join(", ", e.getSupportedHttpMethods().stream()
                .map(httpMethod -> httpMethod.name()).toList());

        BasedError<Object> basedError = BasedError.builder()
                .code(HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase())
                .description("Http Method : "+method+" is not supported. Supported Methods : "+supportedMethods)
                .timeStamp(LocalDateTime.now().toString())
                .build();

        return new BasedErrorResponse(basedError);
    }
}
