package sumatra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlayerInWaterTest {

    private Player p1, p2;
    private Tile t1, t2;

    @BeforeEach
    public void init(){
        t1 = new Tile(0, 0);
        t2 = new Tile(1, 0);
        p1 = spy(new Researcher(t1, 0));
        p2 = spy(new Researcher(t2, 1));
        t1.accept(p1);
        t2.accept(p2);
    }

    @Test
    public void fallInWater_notNeighbor(){

        p1.fallInWater();

        verify(p2, never()).saveMe(p1, t1);
    }

    @Test
    public void fallInWater_hasNeighbor(){
        t1.addNeighbor(t2);

        p1.fallInWater();

        verify(p2).saveMe(p1, t1);
    }

    @Test
    public void saveMe_noRope(){

        p2.saveMe(p1, t1);

        assertNotEquals(p2.getTile(), p1.getTile());
    }

    @Test
    public void saveMe_hasRope(){
        p2.addRope(new BasicRope());

        p2.saveMe(p1, t1);

        assertEquals(t2, p1.getTile());
        assertEquals(t2, p2.getTile());
        assertTrue(t2.creatures.contains(p1));
        assertTrue(t2.creatures.contains(p2));
        assertFalse(t1.creatures.contains(p1));
        assertFalse(t1.creatures.contains(p2));
    }

    @Test
    public void fallInWater_divingSuit(){
        DivingSuit s = new BasicDivingSuit();
        s.giveToPlayer(p1);

        p1.fallInWater();

        verify(p2, never()).saveMe(p1, t1);
    }

}
