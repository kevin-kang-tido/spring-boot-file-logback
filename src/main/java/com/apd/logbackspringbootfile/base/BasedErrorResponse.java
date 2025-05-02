package com.apd.logbackspringbootfile.base;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasedErrorResponse {

    private  BasedError error;
}
