package pdf.to.word.services;
import org.junit.jupiter.api.Test;

import com.adobe.pdfservices.operation.io.FileRef;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class PdfToWordConverterTest {

    @Test
    void testConvertPdfToWord() {

        String path = System.getProperty("user.dir") + "/src/test/java/pdf/to/word/resources/example.pdf";

        PdfToWordConverter converter = new PdfToWordConverter();
        String outputPath = converter.convertToWord(path);

        File file = new File(outputPath);
        assertTrue(file.exists());
    }
}
