package common.util;

import common.interfaces.TimeConverter;

import java.time.DateTimeException;
import java.time.LocalTime;

public class LocalTimeConverter implements TimeConverter {
    /**
     * This method is used to check if the time string is of the right format: 08:00. Only then it can be converted.
     *
     * @param value
     * @return
     */
    public LocalTime tryParse(String value) {
        LocalTime time;

        try {
            if (value.isEmpty() || value.length() < 5) {
                time = null;
            } else {
                String[] splitValue = value.split(":");
                boolean checked = checkChars(splitValue);

                if (checked) {
                    time = LocalTime.parse(value);
                } else {
                    time = null;
                }
            }
        } catch (DateTimeException e) {
            time = null;
        }
        return time;
    }

    private static boolean checkChars(String[] array) {
        for (String item : array) {
            int itemLength = item.length();

            if (itemLength > 2) {
                return false;
            }
            for (int i = 0; i < item.length(); i++) {
                try {
                    char c = item.charAt(i);
                    String stringValue = String.valueOf(c);
                    /*
                    check if char can be converted to int
                    if not catch exception and return false;
                     */
                    int intValue = Integer.parseInt(stringValue);
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
        return true;
    }
}
