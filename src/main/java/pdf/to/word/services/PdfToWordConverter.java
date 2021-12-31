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

    static ExecutionContext setUpContext() throws IOException {
        return ExecutionContext.create(Credentials.serviceAccountCredentialsBuilder()
                .fromFile("pdfservices-api-credentials.json").build());
    };//TODO: Use a config file to store credential path
    //TODO: move this function elsewhere and call it only once

    static String convertToWord(String path) throws IOException, ServiceApiException {
        ExportPDFOperation exportPdfOperation = ExportPDFOperation.createNew(ExportPDFTargetFormat.DOCX);
        exportPdfOperation.setInput(FileRef.createFromLocalFile(path));
        String outputPath = Files.createTempDirectory("temp") + "/output/convertedResult.docx";
        exportPdfOperation.execute(setUpContext()).saveAs(outputPath);
        return outputPath;
    }
};
