package persistence.common;

public class Constants {
    private Constants(){}

    public static final String DB_NAME = "src/main/resources/stayactive_db.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + DB_NAME;

    public class AlertExerciseTable {
        private AlertExerciseTable(){}

        public static final String TABLE = "alert_exercise";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_ALERT_ID = "alert_id";
        public static final String COLUMN_EXERCISE_ID = "exercise_id";
        public static final String COLUMN_EXERCISE_WEIGHT = "exercise_weight";
    }

    public class AlertTable {
        private AlertTable(){}

        public static final String TABLE = "alert";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_USER_ID = "user_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_START_TIME = "start_time";
        public static final String COLUMN_END_TIME = "end_time";
    }

    public class ExerciseTable {
        private ExerciseTable(){}

        public static final String TABLE = "exercise";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_REPS = "reps";
        public static final String COLUMN_SETS = "sets";
        public static final String COLUMN_LEVEL = "level";
        public static final String COLUMN_TIME = "time";
    }

    public class UserExerciseHistoryTable {
        private UserExerciseHistoryTable(){}

        public static final String TABLE = "user_exercise_history";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_USER_ID = "user_id";
        public static final String COLUMN_EXERCISE_ID = "exercise_id";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_DURATION = "duration";
    }

    public class UserTable {
        private UserTable(){}

        public static final String TABLE = "user";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_LEVEL = "level";
    }



}
