package sumatra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlayerMiscTest {

    private Tile t;
    private Player p;

    @BeforeEach
    public void init(){
        t = mock(Tile.class);
        p = new Eskimo(t, 0);
    }

    @Test
    public void decreaseMana(){
        p.mana = 3;
        p.decreaseMana();
        assertEquals(2, p.mana);
    }

    @Test
    public void replenishMana(){
        p.mana = 0;
        p.playRound();
        assertEquals(4, p.mana);
    }

    @Test
    public void damage(){
        p.health = 6;
        p.damage(2);
        assertEquals(4, p.health);
    }

    @Test
    public void heal(){
        p.health = 3;
        p.heal(2);
        assertEquals(5, p.health);
    }

    @Test
    public void dig(){
        Player p = spy(this.p);
        p.dig();
        verify(t).removeSnow(1);
        verify(p).decreaseMana();
    }

    @Test
    public void dig_noMana(){
        p.mana = 0;
        p.dig();
        verify(t, never()).removeSnow(anyInt());
    }

}
