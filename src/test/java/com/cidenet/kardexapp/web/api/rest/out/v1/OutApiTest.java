package com.cidenet.kardexapp.web.api.rest.out.v1;

import com.cidenet.kardexapp.auth.test.AuthTest;
import com.cidenet.kardexapp.commons.constants.api.EnpointApi;
import com.cidenet.kardexapp.commons.constants.api.out.IEndpointOut;
import com.cidenet.kardexapp.commons.domains.generic.OutDTO;
import com.cidenet.kardexapp.testdatabuilder.OutDTOTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
class OutApiTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createOut() throws Exception {
        OutDTO outDTO = new OutDTOTestDataBuilder().OutBuilder();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(AuthTest.createToken());
        mvc.perform(MockMvcRequestBuilders
                .post(EnpointApi.BASE_PATH.concat(IEndpointOut.CREATE_OUT))
                .content(objectMapper.writeValueAsString(outDTO))
                .headers(headers)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }
    @Test
    void createOutFail() throws Exception {
        OutDTO outDTO = new OutDTOTestDataBuilder().OutBuilder();
        outDTO.setQuantity(100000);
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(AuthTest.createToken());
        mvc.perform(MockMvcRequestBuilders
                .post(EnpointApi.BASE_PATH.concat(IEndpointOut.CREATE_OUT))
                .content(objectMapper.writeValueAsString(outDTO))
                .headers(headers)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isConflict());
    }
}