package sumatra;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


public class HoleItemTest {

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
}
