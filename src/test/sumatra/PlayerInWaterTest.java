package sumatra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        verify(p1, never()).decreaseMana();
        verify(p2, never()).decreaseMana();
    }

    @Test
    public void saveMe(){
        Rope r = mock(Rope.class);
        p2.addRope(r);

        p2.saveMe(p1, t1);

        verify(r).save(p1, t1, t2);
        verify(p1, never()).decreaseMana();
        verify(p2, never()).decreaseMana();
    }

    @Test
    public void fallInWater_divingSuit(){
        DivingSuit s = new BasicDivingSuit();
        s.giveToPlayer(p1);

        p1.fallInWater();

        verify(p2, never()).saveMe(p1, t1);
    }

}
