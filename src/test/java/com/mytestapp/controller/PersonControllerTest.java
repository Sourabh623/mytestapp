package com.mytestapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mytestapp.model.Person;
import com.mytestapp.service.PersonService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(value = PersonController.class)
class PersonControllerTest {

    //create a dummy bean of the service class
    @MockBean
    private PersonService personService;

    //this bean responsible for to the send request from the server or rest api
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreatePerson() throws Exception {
        //make a dummy data
        Mockito.when(personService.createPerson(ArgumentMatchers.any())).thenReturn(new Person());

        //make a dummy data send to the rest api or server
        Person person = new Person(5,"Nihal","bhopal");

        //convert object into json using object mapper
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(person);
        System.out.println("object convert into json data is -> "+jsonString);

        //make a post request with data
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString);

        //send request to the server
        ResultActions perform = mockMvc.perform(requestBuilder);

        //perform the operation to the server
        MvcResult mvcResult = perform.andReturn();

        //get the response to the server
        MockHttpServletResponse response = mvcResult.getResponse();

        //get the status to the response
        int status = response.getStatus();

        //check expected and actual status
        assertEquals(201,status);
    }
}