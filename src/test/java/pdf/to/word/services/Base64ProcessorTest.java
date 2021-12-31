package pdf.to.word.services;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class Base64ProcessorTest {

    @Test
    void testEncodeDocument() throws IOException {
        String encodedDocument = Base64Processor.encodeDocument("src/test/java/pdf/to/word/resources/example.docx");
        assertEquals("==", encodedDocument.substring(encodedDocument.length()-2));
    }

    @Test
    void testDecodePdf() throws IOException {
        String encodedPdf = Base64Processor.encodeDocument("src/test/java/pdf/to/word/resources/example.pdf");
        String decodedPdfPath = Base64Processor.decodePdf(encodedPdf);
        File file = new File(decodedPdfPath);
        assertTrue(file.exists());
    };
}
