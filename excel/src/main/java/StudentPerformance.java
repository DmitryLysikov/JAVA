import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StudentPerformance {
    private final UUID id;
    private final UUID studentId;
    private final int maxExerciseScore;
    private final int maxPracticeScore;
    private final int maxSeminarScore;
    private final int maxActivityScore;
    private int totalExerciseScore;
    private int totalPracticeScore;
    private int totalSeminarScore;
    private int totalActivityScore;
    private final List<Topics> topics;

    public StudentPerformance(UUID id,
                              UUID studentId,
                              int maxExerciseScore,
                              int maxPracticeScore,
                              int maxSeminarScore,
                              int totalExerciseScore,
                              int totalPracticeScore,
                              int totalSeminarScore, int maxActivityScore) {
        this.id = id;
        this.studentId = studentId;
        this.maxExerciseScore = maxExerciseScore;
        this.maxPracticeScore = maxPracticeScore;
        this.maxSeminarScore = maxSeminarScore;
        this.totalExerciseScore = totalExerciseScore;
        this.totalPracticeScore = totalPracticeScore;
        this.totalSeminarScore = totalSeminarScore;
        this.maxActivityScore = maxActivityScore;
        topics = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public int getMaxPracticeScore() {
        return maxPracticeScore;
    }

    public int getMaxSeminarScore() {
        return maxSeminarScore;
    }

    public int getTotalExerciseScore() {
        return totalExerciseScore;
    }

    public void setTotalExerciseScore(int totalExerciseScore) {
        if (totalExerciseScore >= 0 && totalExerciseScore <= maxExerciseScore) {
            this.totalExerciseScore = totalExerciseScore;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getTotalPracticeScore() {
        return totalPracticeScore;
    }

    public void setTotalPracticeScore(int totalPracticeScore) {
        if (totalPracticeScore >= 0 && totalPracticeScore <= maxPracticeScore) {
            this.totalPracticeScore = totalPracticeScore;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getTotalSeminarScore() {
        return totalSeminarScore;
    }

    public void setTotalSeminarScore(int totalSeminarScore) {
        if (totalSeminarScore >= 0 && totalSeminarScore <= maxSeminarScore) {
            this.totalSeminarScore = totalSeminarScore;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public List<Topics> getTopics() {
        return List.copyOf(topics);
    }

    public void addTopics(List<Topics> newTopics) {
        if (newTopics != null && !newTopics.isEmpty()) {
            topics.addAll(newTopics);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void addTopics(Topics newTopic) {
        if (newTopic != null) {
            topics.add(newTopic);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getMaxExerciseScore() {
        return maxExerciseScore;
    }

    public int getMaxActivityScore() {
        return maxActivityScore;
    }

    public int getTotalActivityScore() {
        return totalActivityScore;
    }

    public void setTotalActivityScore(int totalActivityScore) {
        if (totalActivityScore >= 0 && totalActivityScore <= maxActivityScore) {
            this.totalActivityScore = totalActivityScore;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
