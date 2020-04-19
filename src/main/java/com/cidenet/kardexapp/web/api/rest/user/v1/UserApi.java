package com.cidenet.kardexapp.web.api.rest.user.v1;

import com.cidenet.kardexapp.commons.constants.api.EnpointApi;
import com.cidenet.kardexapp.commons.constants.api.user.IEndpointUser;
import com.cidenet.kardexapp.commons.domains.request.UserLoginDTO;
import com.cidenet.kardexapp.commons.domains.response.builder.ResponseBuilder;
import com.cidenet.kardexapp.commons.enums.TransactionState;
import com.cidenet.kardexapp.service.security.ISecurityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = EnpointApi.BASE_PATH)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PATCH, RequestMethod.PUT})
public class UserApi {

    private final ISecurityService securityService;

    public UserApi(ISecurityService securityService) {
        this.securityService = securityService;
    }

    @ResponseBody
    @PostMapping(IEndpointUser.LOGIN)
    public ResponseEntity<?> login(@RequestBody UserLoginDTO userLoginDTO) {
        String token = securityService.authenticate(userLoginDTO.getEmail(), userLoginDTO.getPassword());
        return ResponseBuilder.newBuilder()
                .withResponse("Login Ok")
                .withHeader("token", token)
                .withStatus(HttpStatus.OK)
                .withTransactionState(TransactionState.OK)
                .buildResponse();
    }
}
