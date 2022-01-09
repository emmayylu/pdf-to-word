package pdf.to.word.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import pdf.to.word.services.Base64Processor;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DocumentController.class)
public class DocumentControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
     void testConvertToWord() throws Exception{
        String encodedPdf = Base64Processor.encodeDocument("src/test/java/pdf/to/word/resources/example.pdf");
        RequestBuilder request = post("/word").accept(MediaType.APPLICATION_JSON).content(encodedPdf).contentType(MediaType.APPLICATION_JSON);
        String result = mvc.perform(request).andReturn().getResponse().getContentAsString();
        assertFalse(result.isEmpty());
    }

}
