package com.apd.logbackspringbootfile.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class ApiResponse<T> {
    private T payload;
    private HttpStatus status;
    private String message;
    private LocalDateTime date;

}
