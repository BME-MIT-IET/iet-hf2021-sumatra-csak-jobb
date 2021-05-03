package sumatra;

import graphics.IView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TileTest {

    @Test
    void pickUpItem_noSnowOnTile() {
        Tile tile = new Tile(1, 0);
        Item item = mock(Item.class);
        Player player = mock(Player.class);
        tile.placeItem(item);
        tile.pickUpItem(player);
        verify(item, times(1)).giveToPlayer(player);
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