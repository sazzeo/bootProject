package org.example.springboot.web;

import org.example.springboot.web.dto.HelloDtoController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloDtoController.class)
public class HelloDtoControllerTest {



    @Autowired
    private MockMvc mvc;

    @Test
    public void dto리턴() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello/dto")
                        .param("name" , "jee")
                        .param("age" , "27"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("jee")))
                .andExpect(jsonPath("$.age", is(27)));



    }



}
