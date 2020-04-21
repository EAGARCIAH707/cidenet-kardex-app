package com.cidenet.kardexapp.web.api.rest.product.v1;

import com.cidenet.kardexapp.auth.test.AuthTest;
import com.cidenet.kardexapp.commons.constants.api.EnpointApi;
import com.cidenet.kardexapp.commons.constants.api.in.IEndpointIn;
import com.cidenet.kardexapp.commons.constants.api.product.IEndpointProduct;
import com.cidenet.kardexapp.commons.domains.generic.InDTO;
import com.cidenet.kardexapp.commons.domains.generic.ProductDTO;
import com.cidenet.kardexapp.testdatabuilder.InDTOTestDataBuilder;
import com.cidenet.kardexapp.testdatabuilder.ProductDTODataBuilder;
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
class ProductApiTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createProduct() throws Exception {
        ProductDTO product = new ProductDTODataBuilder().productBuilder();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(AuthTest.createToken());
        mvc.perform(MockMvcRequestBuilders
                .post(EnpointApi.BASE_PATH.concat(IEndpointProduct.CREATE_PRODUCT))
                .content(objectMapper.writeValueAsString(product))
                .headers(headers)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void getAll() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(AuthTest.createToken());
        mvc.perform(MockMvcRequestBuilders
                .get(EnpointApi.BASE_PATH.concat(IEndpointProduct.GET_PRODUCTS))
                .headers(headers)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}