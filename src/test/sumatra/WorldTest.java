package sumatra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WorldTest {

    private World world;

    private Gun gun = new Gun();
    private Beacon beacon = new Beacon();
    private Cartridge cartridge = new Cartridge();

    @BeforeEach
    void initialize() {
        world = World.getInstance();

        gun = new Gun();
        beacon = new Beacon();
        cartridge = new Cartridge();
    }

    @Test
    void getInstance_nonNull() {
        assertNotNull(world);
    }

    @Test
    void getInstance_noNewInstance() {
        World againInstance = World.getInstance();

        assertEquals(world, againInstance);
    }

    @Test
    void checkEndGame_notEnoughPartsnotSameTile() {
        Tile tile1 = new Tile(1, 1);
        Tile tile2 = new Tile(2, 1);
        Creature c1 = mock(Creature.class);
        Creature c2 = mock(Creature.class);
        c1.tile = tile1;
        tile1.accept(c1);
        c2.tile = tile2;
        tile2.accept(c2);
        world.addTile(tile1);
        world.addTile(tile2);
        world.addCreature(c1);
        world.addCreature(c2);

        world.checkEndGame();


    }
}
