package com.cidenet.kardexapp.web.api.rest.user.v1;

import com.cidenet.kardexapp.commons.constants.api.EnpointApi;
import com.cidenet.kardexapp.commons.constants.api.user.IEndpointUser;
import com.cidenet.kardexapp.commons.domains.request.UserLoginDTO;
import com.cidenet.kardexapp.commons.domains.response.builder.ResponseBuilder;
import com.cidenet.kardexapp.commons.enums.TransactionState;
import com.cidenet.kardexapp.service.security.ISecurityService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = EnpointApi.BASE_PATH)
@CrossOrigin(origins = "*")
@Log4j2
public class UserApi {

    private final ISecurityService securityService;

    public UserApi(ISecurityService securityService) {
        this.securityService = securityService;
    }

    @ResponseBody
    @PostMapping(IEndpointUser.LOGIN)
    public ResponseEntity<?> login(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("User Login  {}", userLoginDTO);
        String token = securityService.authenticate(userLoginDTO.getEmail(), userLoginDTO.getPassword());
        return ResponseBuilder.newBuilder()
                .withResponse(token)
                .withHeader("token", token)
                .withStatus(HttpStatus.OK)
                .withTransactionState(TransactionState.OK)
                .buildResponse();
    }
}
