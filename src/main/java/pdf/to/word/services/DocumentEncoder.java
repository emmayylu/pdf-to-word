package pdf.to.word.services;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class DocumentEncoder {
    /**
     * Base64 encode a document.
     * @param path Location in which the document to convert is stored.
     * @return String Base64 encoded result
     * @throws IOException
     */
    static String encodeDocument(String path) throws IOException {
        File file = new File(path);
        return Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(file));
    }
}
