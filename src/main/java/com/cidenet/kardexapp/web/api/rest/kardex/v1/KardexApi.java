package com.cidenet.kardexapp.web.api.rest.kardex.v1;

import com.cidenet.kardexapp.commons.constants.api.EnpointApi;
import com.cidenet.kardexapp.commons.constants.api.kardex.EndpointKardex;
import com.cidenet.kardexapp.commons.domains.response.builder.ResponseBuilder;
import com.cidenet.kardexapp.model.entities.KardexEntity;
import com.cidenet.kardexapp.service.kardex.IKardexService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = EnpointApi.BASE_PATH)
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
                .withMessage("consulta exitosa")
                .withStatus(HttpStatus.OK)
                .buildResponse();
    }


}
