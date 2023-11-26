public class Topics {
    private final int idTopics;
    private final String name;
    private int maxExerciseScore;
    private int maxPracticeScore;
    private int maxSeminarScore;
    private int maxActivityScore;

    public Topics(int idTopics, String name){
        this.idTopics = idTopics;
        this.name = name;
    }

    public Topics(int idTopics, String name, int maxExerciseScore, int maxPracticeScore, int maxSeminarScore,
                  int maxActivityScore){
        this.idTopics = idTopics;
        this.name = name;
        this.maxExerciseScore = maxExerciseScore;
        this.maxPracticeScore = maxPracticeScore;
        this.maxSeminarScore =maxSeminarScore;
        this.maxActivityScore = maxActivityScore;
    }

    public int getMaxExerciseScore() {
        return maxExerciseScore;
    }

    public void setMaxExerciseScore(int maxExerciseScore) {
        this.maxExerciseScore = maxExerciseScore;
    }

    public int getMaxPracticeScore() {
        return maxPracticeScore;
    }

    public void setMaxPracticeScore(int maxPracticeScore) {
        this.maxPracticeScore = maxPracticeScore;
    }

    public int getMaxSeminarScore() {
        return maxSeminarScore;
    }

    public void setMaxSeminarScore(int maxSeminarScore) {
        this.maxSeminarScore = maxSeminarScore;
    }

    public int getMaxActivityScore() {
        return maxActivityScore;
    }

    public void setMaxActivityScore(int maxActivityScore) {
        this.maxActivityScore = maxActivityScore;
    }

    public int getIdTopics() {
        return idTopics;
    }

    public String getName() {
        return name;
    }
}
