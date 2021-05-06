package sumatra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerMoveTest {

    private Tile t0, t1;
    private Player p;

    @BeforeEach
    public void init(){
        t0 = new Tile(0, 0);
        t1 = new Tile(1, 0);
        p = new Eskimo(t0, 0);
        t0.accept(p);
    }

    @Test
    public void move_neighbor(){
        t0.addNeighbor(t1);

        p.move(t1);

        assertEquals(t1, p.getTile());
        assertTrue(t1.creatures.contains(p));
        assertFalse(t0.creatures.contains(p));
    }

    @Test
    public void move_notNeighbor(){

        p.move(t1);

        assertEquals(t0, p.getTile());
        assertTrue(t0.creatures.contains(p));
        assertFalse(t1.creatures.contains(p));
    }

    @Test
    public void move_noMana(){
        t0.addNeighbor(t1);
        p.mana = 0;

        p.move(t1);

        assertEquals(t0, p.getTile());
        assertTrue(t0.creatures.contains(p));
        assertFalse(t1.creatures.contains(p));
    }

    @Test
    public void forceMove(){
        t0.addNeighbor(t1);
        p.mana = 0;

        p.forceMove(t1);

        assertEquals(t1, p.getTile());
        assertTrue(t1.creatures.contains(p));
        assertFalse(t0.creatures.contains(p));
    }

}

