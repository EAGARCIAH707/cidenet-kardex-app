package com.cidenet.kardexapp.web.api.rest.kardex.v1;

import com.cidenet.kardexapp.commons.constants.api.EnpointApi;
import com.cidenet.kardexapp.commons.constants.api.kardex.EndpointKardex;
import com.cidenet.kardexapp.commons.domains.response.builder.ResponseBuilder;
import com.cidenet.kardexapp.commons.enums.TransactionState;
import com.cidenet.kardexapp.model.entities.KardexEntity;
import com.cidenet.kardexapp.service.kardex.IKardexService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = EnpointApi.BASE_PATH)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PATCH, RequestMethod.PUT})
public class KardexApi {
    private final IKardexService kardexService;

    public KardexApi(IKardexService kardexService) {
        this.kardexService = kardexService;
    }

    @GetMapping(EndpointKardex.FIND_KARDEX_BY_ID)
    public ResponseEntity<?> getKardexById(@PathVariable("kardexId") Integer kardexId) throws NotFoundException {
        KardexEntity kardexResponse = kardexService.findKardexById(kardexId);
        return ResponseBuilder.newBuilder()
                .withResponse(kardexResponse)
                .withPath(EndpointKardex.FIND_KARDEX_BY_ID)
                .withMessage("successful consultation")
                .withStatus(HttpStatus.OK)
                .withTransactionState(TransactionState.OK)
                .buildResponse();
    }

    @GetMapping(EndpointKardex.FIND_ALL)
    public ResponseEntity<?> findAll() {
        List<KardexEntity> kardexResponse = kardexService.findAll();
        return ResponseBuilder.newBuilder()
                .withResponse(kardexResponse)
                .withPath(EndpointKardex.FIND_ALL)
                .withMessage("successful consultation")
                .withStatus(HttpStatus.OK)
                .withTransactionState(TransactionState.OK)
                .buildResponse();
    }


}
