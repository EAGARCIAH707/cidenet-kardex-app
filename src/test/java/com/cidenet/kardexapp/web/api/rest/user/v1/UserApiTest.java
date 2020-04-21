package com.cidenet.kardexapp.web.api.rest.user.v1;

import com.cidenet.kardexapp.commons.constants.api.EnpointApi;
import com.cidenet.kardexapp.commons.constants.api.user.IEndpointUser;
import com.cidenet.kardexapp.commons.domains.request.UserLoginDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class UserApiTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void login() throws Exception {
        UserLoginDTO login = UserLoginDTO.builder().email("usertest").password("12345678").build();
        mvc.perform(MockMvcRequestBuilders
                .post(EnpointApi.BASE_PATH.concat(IEndpointUser.LOGIN))
                .content(objectMapper.writeValueAsString(login))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}