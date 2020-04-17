package com.cidenet.kardexapp.commons.domains.request;

import lombok.Data;

@Data
public class UserLoginDTO {

    private String email;
    private String password;

}
