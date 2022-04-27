package amcode.application.common.util;

import java.time.LocalTime;

public class LocalTimeConverter {
    public LocalTime tryParse(String value) {
        LocalTime time;

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
        return time;
    }

    private static boolean checkChars(String[] array) {
        for (String item: array) {
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
