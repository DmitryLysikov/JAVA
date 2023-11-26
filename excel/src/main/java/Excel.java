import java.io.FileInputStream;
import java.util.Iterator;
import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excel {
    public static void main(String[] args) throws Exception {
        try {
            FileInputStream excelFile = new FileInputStream("C:\\Users\\lysik\\Downloads\\JAVA\\basicprogramming.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case NUMERIC -> System.out.print(cell.getNumericCellValue() + "\t");
                        case STRING -> System.out.print(cell.getStringCellValue() + "\t\t");
                    }
                }
                System.out.println();
            }
            excelFile.close();
        }catch (Exception e){
            System.out.println("WHAT?????");
        }
    }
}
