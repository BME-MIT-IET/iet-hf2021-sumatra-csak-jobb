package sumatra;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class HoleTileTest {

    @Test
    void placeItem_noItem() {
        HoleTile ht = new HoleTile(1, 1);

        assertNull(ht.getItem());
    }

    @Test
    void placeItem_oneItem() {
        HoleTile ht = new HoleTile(1, 1);
        Item item = mock(Item.class);

        boolean placeSucces = ht.placeItem(item);

        assertNull(ht.getItem());
        assertFalse(placeSucces);
    }

    @Test
    void accept_playerFallsInWater() {
        HoleTile ht = new HoleTile(1, 2);
        Creature c = mock(Creature.class);

        ht.accept(c);

        verify(c, times(1)).fallInWater();
        verifyNoMoreInteractions(c);
    }
}
