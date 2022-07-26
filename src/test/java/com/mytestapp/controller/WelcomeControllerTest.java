package com.mytestapp.controller;

import com.mytestapp.service.WelcomeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(value = WelcomeController.class)
class WelcomeControllerTest {

    //create a dummy bean of the service class
    @MockBean
    private WelcomeService welcomeService;

    //this bean responsible for to the send request from the server or rest api
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testWelcomeMessage() throws Exception {
        //create a dummy data of the service class for the testing
        Mockito.when(welcomeService.getMessage()).thenReturn("Good Morning");

        //make a request for the controller test
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome");

        //send the request to the rest api or server
        //we need first mock mvc bean for send request to the server
        ResultActions perform = mockMvc.perform(requestBuilder);

        //perform the operation on server and get the response to the server
        MvcResult mvcResult = perform.andReturn();

        //get the response from the server
        MockHttpServletResponse response = mvcResult.getResponse();

        //get the status code from the server
        int status = response.getStatus();

        //check status is success or not
        //if status is success then test is passed.
        assertEquals(200,status);
    }
}