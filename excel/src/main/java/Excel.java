import org.apache.poi.ss.usermodel.*;

import java.sql.*;


public class Excel {
    public static void main(String[] args) throws Exception {
        ReaderExcel reader = new ReaderExcel("C:\\Users\\lysik\\Desktop\\git\\JAVA1\\JAVA\\basicprogramming.xlsx");

        Sheet sheet = reader.getSheet();
        ParsExcel parser = new ParsExcel(sheet);
        var topic = parser.parseAndGetTopics();
        var students = parser.parseAndGetStudents();

//        for (Student currentStudent: students) {
//            System.out.println(currentStudent.getName() + " " +
//                    currentStudent.getSurname() + " " +
//                    currentStudent.getUlearnID() + " " +
//                    currentStudent.getEmail() + " " +
//                    currentStudent.getStudentGroup());
//        }
        for (Topics topics : topic) {
            System.out.print(topics.getIdTopics());
            System.out.println(topics.getName());
        }

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproct","root","Vladalove082409@");

//        String insertQuery = "INSERT INTO student(namee,surname,email,studentgroup) VALUES (?,?,?,?)";
//        PreparedStatement statement = connection.prepareStatement(insertQuery);
        int i=0;
        // Заполняем запрос данными из объекта
//        for (Student student : students) {
//            statement.setString(1, student.getName());
//            statement.setString(2, student.getSurname());
//            statement.setString(3, student.getEmail());
//            statement.setString(4, student.getStudentGroup());
//            statement.addBatch();
//            i++;
//            if (i % 1000 == 0 || i == students.size()) {
//                statement.executeBatch();
//            }
//        }
        String insertQueryTopics = "INSERT INTO topics(idtopics,topicsname) VALUES (?,?)";
        PreparedStatement statement = connection.prepareStatement(insertQueryTopics);
        int j=0;
        for (Topics topics : topic) {
            statement.setInt(1, topics.getIdTopics());
            statement.setString(2, topics.getName());
            statement.addBatch();
            j++;
            if (j % 1000 == 0 || j == topic.size()) {
                statement.executeBatch();
            }
        }
        int count = statement.executeUpdate();
        System.out.println(count);
    }
}
