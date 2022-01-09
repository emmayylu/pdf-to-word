package pdf.to.word.controllers;

import java.io.IOException;
import com.adobe.pdfservices.operation.exception.ServiceApiException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import pdf.to.word.services.Base64Processor;
import pdf.to.word.services.PdfToWordConverter;

@RestController
@EnableAutoConfiguration
public class DocumentController {

    @PostMapping(value = "/word")
    public @ResponseBody
    String convertToWord(@RequestBody String encodedPdf) throws IOException, ServiceApiException {
        return Base64Processor.encodeDocument(PdfToWordConverter.convertToWord(Base64Processor.decodePdf(encodedPdf)));
    }

}
