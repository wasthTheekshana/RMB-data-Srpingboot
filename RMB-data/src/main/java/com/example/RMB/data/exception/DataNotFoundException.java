package com.example.RMB.data.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DataNotFoundException extends RuntimeException{

    private String message;
    private String variable;

}
