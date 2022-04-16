package guru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Class with test data")
public class SimpleTest {

    @DisplayName("Demonstration test")
    @Test
    void firstTest() {
        Assertions.assertTrue(3 > 2, "Три больше двух всегда");
        Assertions.assertFalse(2 > 3, "Три больше двух всегда");
        Assertions.assertEquals("Foo", "Bar", "Разные слова на выходе");
        Assertions.assertAll(
                () -> Assertions.assertTrue(3 > 2),
                () -> Assertions.assertFalse(2 > 3)
        );
    }
}
