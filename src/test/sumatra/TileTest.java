package sumatra;

import graphics.IView;
import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class TileTest {

    @Test
    void accept_noCreatures() {
        Tile tile = new Tile(1, 1);
        assertTrue(tile.creatures.isEmpty());
        assertNull(tile.getCreature(1)); //TODO: Issue #6
    }

    @Test
    void accept_oneCreature() {
        Tile tile = new Tile(1, 1);
        Creature c = mock(Creature.class);
        c.index = 3;
        tile.accept(c);
        assertNotNull(tile.getCreature(3)); //TODO: Issue #6
    }

    @Test
    void accept_moreCreatures() {

    }

    @Test
    void remove_playerOnTile() {

    }

    @Test
    void remove_playerNotOnTile() {

    }

    @Test
    void placeItem_noItem() {
        Tile tile = new Tile(1, 0);
        assertNull(tile.getItem());
    }


    @Test
    void placeItem_oneItem() {
        Tile tile = new Tile(1, 0);
        Item item = mock(Item.class);
        assertNull(tile.getItem());
        boolean successFullyPlaced = tile.placeItem(item);
        assertTrue(successFullyPlaced);
        assertEquals(tile.getItem(), item);
    }

    @Test
    void placeItem_twoItems() {
        Tile tile = new Tile(1, 0);
        Item item1 = mock(Item.class);
        Item item2 = mock(Item.class);
        assertNull(tile.getItem());
        tile.placeItem(item1);
        boolean successFullyPlaced = tile.placeItem(item2);
        assertFalse(successFullyPlaced);
        assertEquals(tile.getItem(), item1);
    }

    @Test
    void pickUpItem_noItemAndNoSnowOnTile() {
        Tile tile = new Tile(1, 0);
        Player player = mock(Player.class);
        tile.pickUpItem(player);
    }

    @Test
    void pickUpItem_noSnowOnTile() {
        Tile tile = new Tile(1, 0);
        Item item = mock(Item.class);
        Player player = mock(Player.class);
        tile.placeItem(item);
        tile.pickUpItem(player);
        verify(item, times(1)).giveToPlayer(player);
        assertNull(tile.getItem());
        verifyNoMoreInteractions(item);
        verifyNoMoreInteractions(player);
    }

    @Test
    void pickUpItem_oneSnowOnTile() {
        Tile tile = new Tile(1, 1);
        Item item = mock(Item.class);
        Player player = mock(Player.class);
        tile.placeItem(item);
        tile.pickUpItem(player);
        verify(item, never()).giveToPlayer(player);
        assertNotNull(tile.getItem());
        verifyNoMoreInteractions(item);
        verifyNoMoreInteractions(player);
    }

    @Test
    void pickUpItem_moreSnowOnTile() {
        Tile tile = new Tile(1, 5);
        Item item = mock(Item.class);
        Player player = mock(Player.class);
        tile.placeItem(item);
        tile.pickUpItem(player);
        verify(item, never()).giveToPlayer(player);
        assertNotNull(tile.getItem());
        verifyNoMoreInteractions(item);
        verifyNoMoreInteractions(player);
    }

    @Test
    void updateViews_withOneView() {
        Tile tile = new Tile(1, 1);
        IView view1 = mock(IView.class);
        tile.addView(view1);
        tile.updateViews();
        verify(view1, times(1)).subjectChanged();
        verifyNoMoreInteractions(view1);
    }

    @Test
    void updateViews_withMoreViews() {
        Tile tile = new Tile(1, 1);
        IView view1 = mock(IView.class);
        IView view2 = mock(IView.class);
        tile.addView(view1);
        tile.addView(view2);
        tile.updateViews();
        verify(view1, times(1)).subjectChanged();
        verify(view2, times(1)).subjectChanged();
        verifyNoMoreInteractions(view1);
        verifyNoMoreInteractions(view2);
    }

}