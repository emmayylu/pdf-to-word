package pdf.to.word.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RootController.class)
public class RootControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void testGetWord() throws Exception{
        RequestBuilder request = get("/ping");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("pong", result.getResponse().getContentAsString());
    }






}
