package pdf.to.word.services;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class DocumentEncoder {

    public String encodeDocument(String path) throws IOException {
        File file = new File(path);
        return Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(file));
    }
}
