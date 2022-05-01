package common.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;


class LocalTimeConverterTest {

    @Test
    void tryParseA() {
        // Arrange
        String value = "33:33";

        // Act
        LocalTime localTime = new LocalTimeConverter().tryParse(value);

        // Assert
        Assertions.assertEquals(null, localTime);
    }

    @Test
    void tryParseB() {
        // Arrange
        String value = "as:01";

        // Act
        LocalTime localTime = new LocalTimeConverter().tryParse(value);

        // Assert
        Assertions.assertEquals(null, localTime);
    }

    @Test
    void tryParseC() {
        // Arrange
        String value = "12:33:44";

        // Act
        LocalTime localTime = new LocalTimeConverter().tryParse(value);

        // Assert
        Assertions.assertEquals(null, localTime);
    }

    @Test
    void tryParseD() {
        // Arrange
        String value = "12:33";

        // Act
        LocalTime localTime = new LocalTimeConverter().tryParse(value);

        // Assert
        Assertions.assertEquals("12:33", localTime.toString());
    }

    @Test
    void tryParseE() {
        // Arrange
        String value = "00:00";

        // Act
        LocalTime localTime = new LocalTimeConverter().tryParse(value);

        // Assert
        Assertions.assertEquals("00:00", localTime.toString());
    }
}