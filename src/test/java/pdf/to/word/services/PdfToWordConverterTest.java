package pdf.to.word.services;
import com.adobe.pdfservices.operation.exception.ServiceApiException;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class PdfToWordConverterTest {

    @Test
    void testConvertPdfToWord() throws ServiceApiException, IOException {
        PdfToWordConverter converter = new PdfToWordConverter();
        String outputPath = converter.convertToWord("src/test/java/pdf/to/word/resources/example.pdf");
        File file = new File(outputPath);
        assertTrue(file.exists());
    }
}
