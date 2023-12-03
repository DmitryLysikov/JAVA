import org.apache.poi.ss.usermodel.*;

import java.sql.*;


public class Excel {
    public static void main(String[] args) throws Exception {
        ReaderExcel reader = new ReaderExcel("C:\\Users\\lysik\\Desktop\\git\\JAVA1\\JAVA\\basicprogramming.xlsx");

        Sheet sheet = reader.getSheet();
        ParsExcel parser = new ParsExcel(sheet);
        var sections = parser.parseAndGetTopics();
        var students = parser.parseAndGetStudents();

//        for (Student currentStudent: students) {
//            System.out.println(currentStudent.getName() + " " +
//                    currentStudent.getSurname() + " " +
//                    currentStudent.getUlearnID() + " " +
//                    currentStudent.getEmail() + " " +
//                    currentStudent.getStudentGroup());
//        }
//        for (Topics topics : sections) {
//            System.out.println(topics.getName());
//        }

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproct","root","Vladalove082409@");
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("INSERT INTO student(namee, surname) VALUES (?, ?)");

//        String insertQuery = "INSERT INTO student(namee, surname) VALUES (?, ?)";
//        PreparedStatement statement = connection.prepareStatement(insertQuery);

//        // Заполняем запрос данными из объекта Employee
//        for (Student student : students) {
//            statement.set(1, student.getName());
//            statement.setString(2, student.getSurname());
//        }
//        int count = statement.executeUpdate();
//        System.out.println(count);
    }
}
