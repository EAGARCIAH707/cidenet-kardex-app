package com.cidenet.kardexapp.web.api.rest.in.v1;

import com.cidenet.kardexapp.commons.constants.api.EnpointApi;
import com.cidenet.kardexapp.commons.constants.api.in.IEndpointIn;
import com.cidenet.kardexapp.commons.domains.generic.InDTO;
import com.cidenet.kardexapp.commons.domains.response.builder.ResponseBuilder;
import com.cidenet.kardexapp.commons.enums.TransactionState;
import com.cidenet.kardexapp.commons.exceptions.SystemException;
import com.cidenet.kardexapp.model.entities.InEntity;
import com.cidenet.kardexapp.service.in.IInService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = EnpointApi.BASE_PATH)
public class InApi {
    private final IInService inService;

    public InApi(IInService inService) {
        this.inService = inService;
    }

    @ResponseBody
    @PostMapping(IEndpointIn.CREATE_IN)
    public ResponseEntity<?> createIn(@RequestBody InDTO inDTO) throws SystemException, NotFoundException {
        InDTO inResponse = inService.createIn(inDTO);
        return ResponseBuilder.newBuilder()
                .withResponse(inResponse)
                .withPath(IEndpointIn.CREATE_IN)
                .withMessage("successfully created")
                .withStatus(HttpStatus.CREATED)
                .withTransactionState(TransactionState.OK)
                .buildResponse();
    }
}
