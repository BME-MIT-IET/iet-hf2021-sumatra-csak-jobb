package sumatra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WorldTest {

    @BeforeEach
    void initialize() {

    }

    @Test
    void getInstance_nonNull() {
        World world = World.getInstance();

        assertNotNull(world);
    }

    @Test
    void getInstance_noNewInstance() {
        World world = World.getInstance();
        World againInstance = World.getInstance();

        assertEquals(world, againInstance);
    }
}
