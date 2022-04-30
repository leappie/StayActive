package model;

public class ExerciseViewModel {
    private String exerciseName;
    private int reps;
    private int sets;
    private int exerciseTime;
    private String level;

    public ExerciseViewModel(String exerciseName, int reps, int sets, int exerciseTime, String level) {
        this.exerciseName = exerciseName;
        this.reps = reps;
        this.sets = sets;
        this.exerciseTime = exerciseTime;
        this.level = level;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public int getReps() {
        return reps;
    }

    public int getSets() {
        return sets;
    }

    public int getExerciseTime() {
        return exerciseTime;
    }

    public String getLevel() {
        return level;
    }
}
