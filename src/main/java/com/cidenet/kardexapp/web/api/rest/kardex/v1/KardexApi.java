package com.cidenet.kardexapp.web.api.rest.kardex.v1;

import com.cidenet.kardexapp.commons.constants.api.EnpointApi;
import com.cidenet.kardexapp.commons.constants.api.kardex.EndpointKardex;
import com.cidenet.kardexapp.commons.domains.generic.KardexDTO;
import com.cidenet.kardexapp.commons.domains.response.builder.ResponseBuilder;
import com.cidenet.kardexapp.commons.enums.TransactionState;
import com.cidenet.kardexapp.model.entities.KardexEntity;
import com.cidenet.kardexapp.service.kardex.IKardexService;
import javassist.NotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = EnpointApi.BASE_PATH)
@CrossOrigin(origins = "*")
@Log4j2
public class KardexApi {
    private final IKardexService kardexService;

    public KardexApi(IKardexService kardexService) {
        this.kardexService = kardexService;
    }

    @GetMapping(EndpointKardex.FIND_KARDEX_BY_ID)
    public ResponseEntity<?> getKardexById(@PathVariable("kardexId") Integer kardexId) throws NotFoundException {
        log.info("[GET] Find Kardex By Id, {}", kardexId);
        KardexDTO kardexResponse = kardexService.findKardexById(kardexId);
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
        log.info("[GET] Find All Kardex");
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
