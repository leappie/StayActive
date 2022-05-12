package common.util;

import enums.Level;

public class LevelConverter {

    public Level tryParse(String value) {
        Level level;
        try {
            if (value.equals("EASY") || value.equals("MEDIUM") || value.equals("HARD")) {
                level = Level.valueOf(value);
            } else {
                level = null;
            }
            return level;
        } catch (Exception e) {
            return null;
        }
    }


}
