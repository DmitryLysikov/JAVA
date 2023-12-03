import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReaderExcel {
    private final String fileName;

    public ReaderExcel(String fileName) {
        File file = new File(fileName);

        if (file.exists()) {
            this.fileName = fileName;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getFileName() {
        return fileName;
    }

    public Sheet getSheet() {
        Sheet sheet;
        try {
            FileInputStream file = new FileInputStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheetAt(0);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        return sheet;
    }
}
