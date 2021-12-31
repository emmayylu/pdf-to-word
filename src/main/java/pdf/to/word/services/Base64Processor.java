package pdf.to.word.services;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.nio.file.*;

public class Base64Processor {
    /**
     * Base64 encode a document.
     * @param path Location in which the document to convert is stored
     * @return String Base64 encoded result
     * @throws IOException
     */
    static String encodeDocument(String path) throws IOException {
        File file = new File(path);
        return Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(file));
    }

    /**
     * Decode base64 encoded PDF.
     * @param encodedPdf Base64 encoded PDF
     * @return String Location in which the decoded PDF is stored
     * @throws IOException
     */
    static String decodePdf(String encodedPdf) throws IOException {
        String decodedPdfPath = Files.createTempDirectory("temp") + "/decodedPdf.pdf";
        FileUtils.writeByteArrayToFile(new File(decodedPdfPath), Base64.getDecoder().decode(encodedPdf));
        return decodedPdfPath;
    }
}
