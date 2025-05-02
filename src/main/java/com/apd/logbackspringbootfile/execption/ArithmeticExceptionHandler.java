package com.apd.logbackspringbootfile.execption;

import com.apd.logbackspringbootfile.base.BasedError;
import com.apd.logbackspringbootfile.base.BasedErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


// TODO handle math Exception
@RestControllerAdvice
public class ArithmeticExceptionHandler {

    @ExceptionHandler({ ArithmeticException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    BasedErrorResponse handleArithmeticException(ArithmeticException e){
        BasedError<Object> basedError = BasedError.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .description("Error with number")
                .timeStamp(LocalDateTime.now().toString())
                .build();
     return new BasedErrorResponse(basedError);
    }
}
