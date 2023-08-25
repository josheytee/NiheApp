package com.josheytee.niheapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {

    int code;
    String message;

    Object data;

}
