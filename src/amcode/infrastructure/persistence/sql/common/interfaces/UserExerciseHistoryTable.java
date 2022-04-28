package amcode.infrastructure.persistence.sql.common.interfaces;

public interface UserExerciseHistoryTable {
    String UEH_TABLE = "user_exercise_history";
    String UEH_COLUMN_ID = "id";
    String UEH_COLUMN_USER_ID = "user_id";
    String UEH_COLUMN_EXERCISE_ID = "exercise_id";
    String UEH_COLUMN_DATE = "date";
    String UEH_COLUMN_DURATION = "duration";
}
