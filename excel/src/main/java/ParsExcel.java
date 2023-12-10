import org.apache.poi.ss.usermodel.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParsExcel {
    private final Sheet sheet;

    public ParsExcel(Sheet sheet) {
        if (sheet == null) {
            throw new IllegalArgumentException("Лист должен быть проинициализирован");
        }

        this.sheet = sheet;
    }

    public List<Student> parseAndGetStudents() {
        ArrayList<Student> students = new ArrayList<>();
        Iterator<Row> rows = sheet.rowIterator();

        while (rows.hasNext()) {
            Row currentRow = rows.next();
            Iterator<Cell> cells = currentRow.cellIterator();
            int columnIndex = 0;
            Student currentStudent = new Student();

            while (columnIndex < 4) {
                Cell currentCell = cells.next();
                String contentCell = currentCell.getStringCellValue();

                if (isIncorrectStudentCell(contentCell)) {
                    break;
                }

                switch (columnIndex) {
                    case 0:
                        parseNameAndSurnameCurrentStudent(contentCell, currentStudent);
                        break;
                    case 1:
                        parseUlearnIdCurrentStudent(contentCell, currentStudent);
                        break;
                    case 2:
                        parseEmailCurrentStudent(contentCell, currentStudent);
                        break;
                    case 3:
                        parseGroupCurrentStudent(contentCell, currentStudent);
                        break;
                }

                columnIndex++;
            }
            if (currentStudent.getName() != null) {
                students.add(currentStudent);
            }
        }

        return students;
    }

    public List<Topics> parseAndGetTopics() {
        ArrayList<Topics> topics = new ArrayList<Topics>();
        Row topicsRow = sheet.getRow(0);
        Iterator<Cell> topicsCells = topicsRow.cellIterator();
        int topicsId = 1;

        while (topicsCells.hasNext()) {
            Cell sectionCell = topicsCells.next();
            String contentCell = sectionCell.getStringCellValue().trim();

            if (isCorrectTopicsCell(contentCell)) {
                Topics section = new Topics(topicsId, contentCell);
                topics.add(section);
                topicsId++;
            }
        }

        return topics;
    }
    private void parseNameAndSurnameCurrentStudent(String contentCell, Student currentStudent) {
        String[] data = contentCell.split(" ");

        if (data.length == 2) {
            currentStudent.setName(data[1]);
            currentStudent.setSurname(data[0]);
        }
    }

    private void parseUlearnIdCurrentStudent(String contentCell, Student currentStudent) {
        UUID uuid = UUID.fromString(contentCell);
        currentStudent.setUlearnID(uuid);
    }

    private void parseEmailCurrentStudent(String contentCell, Student currentStudent) {
        currentStudent.setEmail(contentCell);
    }

    private void parseGroupCurrentStudent(String contentCell, Student currentStudent) {
        currentStudent.setStudentGroup(contentCell);
    }

    private boolean isIncorrectStudentCell(String contentCell) {
        return  contentCell.isEmpty() ||
                contentCell.equals("Фамилия Имя") ||
                contentCell.equals("Максимум:");
    }

    private boolean isCorrectTopicsCell(String contentCell) {
        return  !contentCell.equals("За весь курс") &&
                !contentCell.equals("Преподавателю о курсе") &&
                !contentCell.isEmpty();
    }
}
