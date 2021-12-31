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
    String convertToWord(String path) {
        try {
            Credentials credentials = Credentials.serviceAccountCredentialsBuilder()
                    .fromFile(System.getProperty("user.dir") + "/pdfservices-api-credentials.json").build();
            ExecutionContext executionContext = ExecutionContext.create(credentials);
            ExportPDFOperation exportPdfOperation = ExportPDFOperation.createNew(ExportPDFTargetFormat.DOCX);
            FileRef sourceFileRef = FileRef.createFromLocalFile(path);
            exportPdfOperation.setInput(sourceFileRef);
            FileRef result = exportPdfOperation.execute(executionContext);
            Path tempDirWithPrefix = Files.createTempDirectory("temp");
            String outputPath = tempDirWithPrefix + "/output/convertedResult.docx";
            result.saveAs(outputPath);
            return outputPath;
        } catch (IOException | ServiceApiException e) {
            e.printStackTrace();
        }
        return path;
    }
};
