package com.cidenet.kardexapp.web.api.rest.in.v1;

import com.cidenet.kardexapp.auth.test.AuthTest;
import com.cidenet.kardexapp.commons.constants.api.EnpointApi;
import com.cidenet.kardexapp.commons.constants.api.in.IEndpointIn;
import com.cidenet.kardexapp.commons.constants.api.user.IEndpointUser;
import com.cidenet.kardexapp.commons.domains.generic.InDTO;
import com.cidenet.kardexapp.testdatabuilder.InDTOTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
class InApiTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createIn() throws Exception {
        InDTO inDTO = new InDTOTestDataBuilder().inBuilder();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(AuthTest.createToken());
        mvc.perform(MockMvcRequestBuilders
                .post(EnpointApi.BASE_PATH.concat(IEndpointIn.CREATE_IN))
                .content(objectMapper.writeValueAsString(inDTO))
                .headers(headers)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }
}