package amcode.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class ExerciseHistory {
    private int id;
    private LocalDate date;
    private LocalTime exerciseDuration;

    public ExerciseHistory(int id, LocalDate date, LocalTime exerciseDuration) {
        this.id = id;
        this.date = date;
        this.exerciseDuration = exerciseDuration;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getExerciseDuration() {
        return exerciseDuration;
    }

}
