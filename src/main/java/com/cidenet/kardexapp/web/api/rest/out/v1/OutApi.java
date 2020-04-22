package com.cidenet.kardexapp.web.api.rest.out.v1;

import com.cidenet.kardexapp.commons.constants.api.EnpointApi;
import com.cidenet.kardexapp.commons.constants.api.out.IEndpointOut;
import com.cidenet.kardexapp.commons.domains.generic.OutDTO;
import com.cidenet.kardexapp.commons.domains.response.builder.ResponseBuilder;
import com.cidenet.kardexapp.commons.enums.TransactionState;
import com.cidenet.kardexapp.commons.exceptions.SystemException;
import com.cidenet.kardexapp.model.entities.OutEntity;
import com.cidenet.kardexapp.service.out.IOutService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = EnpointApi.BASE_PATH)
public class OutApi {
    private final IOutService outService;

    public OutApi(IOutService outService) {
        this.outService = outService;
    }

    @ResponseBody
    @PostMapping(IEndpointOut.CREATE_OUT)
    public ResponseEntity<?> createOut(@RequestBody OutDTO outDTO) throws SystemException, NotFoundException {
        OutDTO outResponse = outService.createOut(outDTO);
        return ResponseBuilder.newBuilder()
                .withResponse(outResponse)
                .withPath(IEndpointOut.CREATE_OUT)
                .withMessage("successfully created")
                .withStatus(HttpStatus.CREATED)
                .withTransactionState(TransactionState.OK)
                .buildResponse();
    }
}
