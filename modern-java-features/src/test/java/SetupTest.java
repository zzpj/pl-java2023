import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetupTest {

    @Test
    void shouldRunOnJava17() {
        int feature = Runtime.version().feature();

        assertEquals(17, feature);
    }
}
