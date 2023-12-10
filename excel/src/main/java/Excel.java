import org.apache.poi.ss.usermodel.*;


public class Excel {
    public static void main(String[] args) throws Exception {
        ReaderExcel reader = new ReaderExcel("C:\\Users\\lysik\\Desktop\\git\\JAVA1\\JAVA\\basicprogramming.xlsx");

        Sheet sheet = reader.getSheet();
        ParsExcel parser = new ParsExcel(sheet);
        var topic = parser.parseAndGetTopics();
        var students = parser.parseAndGetStudents();
//        WriteBase writeBase = new WriteBase(topic, students);
//        topic = writeBase.WriteTopics();
//        students = writeBase.WriteStudent();
        var perf = parser.parseAndGetStudentPerformance();

        for(StudentPerformance studentPerformance: perf){
            System.out.println(studentPerformance.getTotalExerciseScore());
        }

//        for (Student currentStudent: students) {
//            System.out.println(currentStudent.getName() + " " +
//                    currentStudent.getSurname() + " " +
//                    currentStudent.getUlearnID() + " " +
//                    currentStudent.getEmail() + " " +
//                    currentStudent.getStudentGroup());
//        }
//        for (Topics topics : topic) {
//            System.out.print(topics.getIdTopics());
//            System.out.println(topics.getName());
//        }

    }
}
