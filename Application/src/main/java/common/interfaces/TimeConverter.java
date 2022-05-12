package common.interfaces;

import java.time.LocalTime;

/**
 * Used to convert time. At the moment I am only converting time of the type 08:00. If I want to expand to 08:00:00,
 * I can use this interface.
 */
public interface TimeConverter {
    LocalTime tryParse(String value);
}
