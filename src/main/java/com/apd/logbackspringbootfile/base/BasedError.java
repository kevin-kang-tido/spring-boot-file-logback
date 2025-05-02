package com.apd.logbackspringbootfile.base;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BasedError<T> {
    // request entity too large  , bad request ....
    //  700
    private  String code;
    // detail error for user
    private  T description;

    private T timeStamp;






}
