package com.cidenet.kardexapp.web.api.rest.kardex.v1;

import com.cidenet.kardexapp.auth.test.AuthTest;
import com.cidenet.kardexapp.commons.constants.api.EnpointApi;
import com.cidenet.kardexapp.commons.constants.api.kardex.EndpointKardex;
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
class KardexApiTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void getKardexById() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(AuthTest.createToken());
        mvc.perform(MockMvcRequestBuilders
                .get(EnpointApi.BASE_PATH.concat("/kardex/1"))
                .headers(headers)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void findAll() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(AuthTest.createToken());
        mvc.perform(MockMvcRequestBuilders
                .get(EnpointApi.BASE_PATH.concat(EndpointKardex.FIND_ALL))
                .headers(headers)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}