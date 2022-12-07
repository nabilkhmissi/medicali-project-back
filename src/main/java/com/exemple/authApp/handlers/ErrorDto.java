package com.exemple.authApp.handlers;

import com.exemple.authApp.exceptions.ErrorCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {
    private Integer httpCode;
    private ErrorCodes code;
    private String message;
    List<String> errors = new ArrayList<>();
}
