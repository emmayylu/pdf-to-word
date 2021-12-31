package pdf.to.word.services;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class DocumentDecoderTest {

    @Test
    void testEncodeDocument() throws IOException {
        DocumentEncoder encoder = new DocumentEncoder();
        String encodedDocument = encoder.encodeDocument("src/test/java/pdf/to/word/resources/example.docx");
        assertEquals(encodedDocument.substring(encodedDocument.length()-2), "==");
    }

}