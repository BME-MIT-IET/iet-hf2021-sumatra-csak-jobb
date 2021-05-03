package sumatra;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class UnstableTileTest {

    @Test
    void accept_oneCreatureFlip(){
        UnstableTile tile = new UnstableTile(0,0,0);
        Creature c = mock(Creature.class);

        tile.accept(c);

        verify(c, times(1)).fallInWater();
    }

    @Test
    void accept_oneCreatureNoFlip() {
        UnstableTile tile = new UnstableTile(0,0,1);
        Creature c = mock(Creature.class);

        tile.accept(c);

        verify(c, never()).fallInWater();
    }

    @Test
    void accept_moreCreaturesNoFlip() {
        UnstableTile tile = new UnstableTile(1, 1, 3);
        Creature c1 = mock(Creature.class);
        Creature c2 = mock(Creature.class);
        Creature c3 = mock(Creature.class);

        tile.accept(c1);
        tile.accept(c2);
        tile.accept(c3);

        verify(c1, never()).fallInWater();
        verify(c2, never()).fallInWater();
        verify(c3, never()).fallInWater();

    }

    @Test
    void accept_moreCreaturesFlip() {
        UnstableTile tile = new UnstableTile(1, 1, 3);
        Creature c1 = mock(Creature.class);
        Creature c2 = mock(Creature.class);
        Creature c3 = mock(Creature.class);
        Creature c4 = mock(Creature.class);

        tile.accept(c1);
        tile.accept(c2);
        tile.accept(c3);
        tile.accept(c4);

        verify(c1, times(1)).fallInWater();
        verify(c2, times(1)).fallInWater();
        verify(c3, times(1)).fallInWater();
        verify(c4, times(1)).fallInWater();
    }


}
