package pdf.to.word.services;

import com.adobe.pdfservices.operation.ExecutionContext;
import com.adobe.pdfservices.operation.exception.ServiceApiException;
import com.adobe.pdfservices.operation.io.FileRef;
import com.adobe.pdfservices.operation.auth.Credentials;
import com.adobe.pdfservices.operation.pdfops.ExportPDFOperation;
import com.adobe.pdfservices.operation.pdfops.options.exportpdf.ExportPDFTargetFormat;

import java.io.IOException;
import java.nio.file.*;

public class PdfToWordConverter {
    /**
     * Set up Adobe service execution context.
     * @return ExecutionContext Adobe service execution context
     * @throws IOException
     */
    static ExecutionContext setUpContext() throws IOException {
        return ExecutionContext.create(Credentials.serviceAccountCredentialsBuilder()
                .fromFile("pdfservices-api-credentials.json").build());
    };//TODO: Use a config file to store credential path
    //TODO: move this function elsewhere and call it only once

    /**
     * Convert PDF to Word document.
     * @param path Location in which the PDF file is stored
     * @return String Location in which the ouput Word file is stored
     * @throws IOException
     * @throws ServiceApiException
     */
    static String convertToWord(String path) throws IOException, ServiceApiException {
        ExportPDFOperation exportPdfOperation = ExportPDFOperation.createNew(ExportPDFTargetFormat.DOCX);
        exportPdfOperation.setInput(FileRef.createFromLocalFile(path));
        String outputPath = Files.createTempDirectory("temp") + "/output/convertedResult.docx";
        exportPdfOperation.execute(setUpContext()).saveAs(outputPath);
        return outputPath;
    }
};
