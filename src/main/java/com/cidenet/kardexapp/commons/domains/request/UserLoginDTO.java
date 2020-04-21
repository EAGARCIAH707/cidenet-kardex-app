package com.cidenet.kardexapp.commons.domains.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginDTO {

    private String email;
    private String password;

}
