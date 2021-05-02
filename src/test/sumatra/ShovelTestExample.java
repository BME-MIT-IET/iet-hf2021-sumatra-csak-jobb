package sumatra;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Example unit test. Please delete this test after you start writing proper ones.
// I only made this because empty folders don't get committed to VCS and the test
// folder is very much needed.
public class ShovelTestExample {

    @Test
    void toString_worksCorrectly() {
        Shovel shovel = new Shovel();
        assertEquals("shovel", shovel.toString());
    }
}
