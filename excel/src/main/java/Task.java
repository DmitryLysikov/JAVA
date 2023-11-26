import java.util.UUID;

public class Task {
    private final int idTask;
    private final String nameTask;
    private UUID sectionId;
    private String sectionName;
    private final TaskСlassification taskClass;
    private int maxScore;;
    private int studentScore;

    public Task(int idTask, String nameTask, TaskСlassification taskClass) {
        this.idTask = idTask;
        this.nameTask = nameTask;
        this.taskClass = taskClass;
    }

    public Task(int idTask, String nameTask, UUID sectionId, String sectionName, TaskСlassification taskClass, int maxScore,
                int studentScore) {
        this.idTask = idTask;
        this.nameTask = nameTask;
        this.sectionId = sectionId;
        this.sectionName = sectionName;
        this.taskClass = taskClass;
        this.maxScore = maxScore;
        this.studentScore = studentScore;
    }

    public int getIdTask() {
        return idTask;
    }

    public String getNameTask() {
        return nameTask;
    }

    public UUID getSectionId() {
        return sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public TaskСlassification getTaskclass() {
        return taskClass;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public int getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(int score) {
        if (score >= 0 && score <= maxScore) {
            studentScore = score;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
