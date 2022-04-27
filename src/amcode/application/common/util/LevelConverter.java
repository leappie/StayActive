package amcode.application.common.util;

import amcode.domain.enums.Level;

public class LevelConverter {
    public Level tryParse(String value) {
        Level level;
        if (value.equals("EASY") || value.equals("MEDIUM") || value.equals("HARD")) {
            level = Level.valueOf(value);
        } else {
            level = null;
        }
        return level;
    }
}
