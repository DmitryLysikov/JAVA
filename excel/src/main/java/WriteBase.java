import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class WriteBase {
    private final List<Topics> topic;
    private final List<Student> students;

    public WriteBase(List<Topics> topic, List<Student> students) {
        if (topic == null && students == null){
            throw new IllegalArgumentException("Пустые брат");
        }
        this.topic = topic;
        this.students = students;
    }

    public List<Topics> WriteTopics() throws SQLException {
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/javaproct","root","Vladalove082409@");
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
        return topic;
    }
    public List<Student> WriteStudent() throws SQLException {
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/javaproct","root","Vladalove082409@");
        String insertQuery = "INSERT INTO student(namee,surname,email,studentgroup) VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(insertQuery);
        int i = 0;
        // Заполняем запрос данными из объекта
        for (Student student : students) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getStudentGroup());
            statement.addBatch();
            i++;
            if (i % 1000 == 0 || i == students.size()) {
                statement.executeBatch();
            }
        }
        return students;
    }
}
