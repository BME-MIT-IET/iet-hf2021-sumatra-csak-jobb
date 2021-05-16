package sumatra;

import graphics.IView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WorldTest {

    private World world;

    private Gun gun = new Gun();
    private Beacon beacon = new Beacon();
    private Cartridge cartridge = new Cartridge();

    @BeforeEach
    void initialize() {
        world = new World();

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
        World instance = World.getInstance();
        World againInstance = World.getInstance();

        assertEquals(instance, againInstance);
    }

    @Test
    void checkEndGame_notEnoughPartsnotSameTile() {
        Tile tile1 = new Tile(1, 1);
        Tile tile2 = new Tile(2, 1);
        Creature c1 = new Eskimo(tile1, 1);
        Creature c2 = new Eskimo(tile2, 2);
        c1.tile = tile1;
        tile1.accept(c1);
        c2.tile = tile2;
        tile2.accept(c2);
        world.addTile(tile1);
        world.addTile(tile2);
        world.addCreature(c1);
        world.addCreature(c2);

        boolean success = world.checkEndGame();

        assertFalse(success);
    }

    @Test
    void checkEndGame_notEnoughPartsSameTile() {
        Tile tile1 = new Tile(2, 1);
        Creature c1 = mock(Creature.class);
        c1.tile = tile1;
        tile1.accept(c1);

        world.registerFlarePart(gun);
        world.registerFlarePart(beacon);

        boolean success = world.checkEndGame();

        assertFalse(success);
    }

    @Test
    void checkEndGame_enoughPartsNotSameTile() {
        Tile tile1 = new Tile(1, 1);
        Tile tile2 = new Tile(2, 1);
        Creature c1 = new Eskimo(tile1, 1);
        Creature c2 = new Eskimo(tile2, 2);
        Creature c3 = new Eskimo(tile1, 3);

        world.addTile(tile1);
        world.addTile(tile2);
        world.addCreature(c1);
        world.addCreature(c2);
        world.addCreature(c3);

        world.registerFlarePart(gun);
        world.registerFlarePart(cartridge);
        world.registerFlarePart(beacon);

        boolean success = world.checkEndGame();

        assertFalse(success);

    }

    @Test
    void checkEndGame_Success() {
        Tile tile1 = new Tile(2, 1);
        Creature c1 = new Eskimo(tile1, 1);
        Creature c2 = new Eskimo(tile1, 1);

        world.registerFlarePart(gun);
        world.registerFlarePart(cartridge);
        world.registerFlarePart(beacon);

        boolean success = world.checkEndGame();

        assertTrue(success);
    }

    @Test
    void generateCreaturesFrom_sample() {
        Tile tile1 = new Tile(1, 1);
        Tile tile2 = new Tile(2, 1);
        Tile tile3 = new Tile(3, 1);
        world.addTile(tile1);
        world.addTile(tile2);
        world.addTile(tile3);
        ArrayList<String> input = new ArrayList<String>();
        input.add("0 researcher");
        input.add("2 eskimo");

        world.generateCreaturesFrom(input);

        Creature c1 = world.getCreatureAt(0);
        Creature c2 = world.getCreatureAt(1);

        assertEquals(2, world.getCreatures().size());
        assertEquals(tile1, c1.getTile());
        assertEquals(tile3, c2.getTile());
        assertEquals(Researcher.class, c1.getClass());
        assertEquals(Eskimo.class, c2.getClass());
    }

    @Test
    void updateViews() {
        IView v1 = mock(IView.class);
        IView v2 = mock(IView.class);
        world.addView(v1);
        world.addView(v2);

        world.updateViews();

        verify(v1, times(1)).subjectChanged();
        verify(v2, times(1)).subjectChanged();
        verifyNoMoreInteractions(v1);
        verifyNoMoreInteractions(v2);
    }
}
