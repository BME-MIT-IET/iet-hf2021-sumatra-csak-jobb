package sumatra;

import graphics.IView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        //TODO
    }

    @Test
    void remove_playerOnTile() {
        //TODO
    }

    @Test
    void remove_playerNotOnTile() {
        //TODO
    }

    @Test
    void clearCreatures_simple() {
        //TODO
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

        boolean successFullyPlaced = tile.placeItem(item);

        assertTrue(successFullyPlaced);
        assertEquals(tile.getItem(), item);
    }

    @Test
    void placeItem_twoItems() {
        Tile tile = new Tile(1, 0);
        Item item1 = mock(Item.class);
        Item item2 = mock(Item.class);

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

        verifyNoMoreInteractions(player);
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
    void getSnow_simple() {
        Tile tile = new Tile(1, 4);

        assertEquals(4, tile.getSnow());
    }

    @Test
    void addSnow_simple() {
        Tile tile = new Tile(1, 3);

        tile.addSnow(2);

        assertEquals(5, tile.getSnow());
    }

    @Test
    void removeSnow_noSnowMinusOne() {
        Tile tile = new Tile(1, 0);

        tile.removeSnow(1);

        assertEquals(0, tile.getSnow());
    }

    @Test
    void removeSnow_hasSnowMinusLessThanAll() {
        Tile tile = new Tile(1, 3);

        tile.removeSnow(2);

        assertEquals(1, tile.getSnow());
    }

    @Test
    void removeSnow_hasSnowMinusAll() {
        Tile tile = new Tile(1, 4);

        tile.removeSnow(4);

        assertEquals(0, tile.getSnow());
    }

    @Test
    void removeSnow_hasSnowMinusMoreThanAll() {
        Tile tile = new Tile(1, 4);

        tile.removeSnow(7);

        assertEquals(0, tile.getSnow());
    }

    @Test
    void revealCapacity_notRevealed() {
        Tile tile = new Tile(1, 1);

        assertFalse(tile.is_capacity_known);
    }

    @Test
    void revealCapacity_revealed() {
        Tile tile = new Tile(1, 1);

        tile.revealCapacity();

        assertTrue(tile.is_capacity_known);
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

    @Test
    void buildTent_notBuilt() {
        Tile tile = new Tile(1, 2);

        assertNotNull(NoBuilding.class);
        assertEquals(NoBuilding.class, tile.getBuilding().getClass());
    }

    @Test
    void buildTent_built() {
        Tile tile = new Tile(1, 1);
        Building b = mock(Building.class);

        tile.setBuilding(b);

        assertEquals(b, tile.getBuilding());
    }

    @Test
    void storm_mockBuildingOnStorm() {
        Tile tile = new Tile(1, 2);
        Building b = mock(Building.class);
        tile.setBuilding(b);

        tile.storm();

        verify(b, times(1)).onStorm(tile.creatures);
        verifyNoMoreInteractions(b);
    }

    @Test
    void addNeighbor_noNeighbor() {
        Tile tile = new Tile(1, 1);
        Tile n = new Tile(2, 2);

        assertFalse(tile.isNeighbor(n));
        assertFalse(n.isNeighbor(tile));
        assertFalse(tile.getNeighbors().contains(n));
        assertFalse(n.getNeighbors().contains(tile));
    }

    @Test
    void addNeighbor_oneNeighbor() {
        Tile tile = new Tile(1, 1);
        Tile n = new Tile(2, 2);

        tile.addNeighbor(n);

        assertTrue(tile.getNeighbors().contains(n));
        assertTrue(tile.isNeighbor(n));
        assertTrue(n.getNeighbors().contains(tile));    // TODO: kolcsonosseg
        assertTrue(n.isNeighbor(tile));                 //
    }

    @Test
    void addNeighbor_moreNeighbor() {
        Tile tile = new Tile(1, 2);
        Tile n1 = new Tile(2, 3);
        Tile n2 = new Tile(3, 4);

        tile.addNeighbor(n1);
        tile.addNeighbor(n2);

        ArrayList<Tile> neighbors = tile.getNeighbors();

        assertTrue(tile.isNeighbor(n1));
        assertTrue(tile.isNeighbor(n2));
        assertFalse(n1.isNeighbor(n2));
        assertFalse(n2.isNeighbor(n1));
    }


    @Test
    void getNeighingCreatures() {
        Tile tile = new Tile(1, 1);
        Tile n1 = new Tile(2, 1);
        Tile n2 = new Tile(3,2);

        tile.addNeighbor(n1);
        n1.addNeighbor(tile);
        tile.addNeighbor(n2);
        n2.addNeighbor(tile);

        Creature c1 = mock(Creature.class);
        Creature c2 = mock(Creature.class);
        Creature c3 = mock(Creature.class);
        Creature c4 = mock(Creature.class);

        tile.accept(c1);
        n1.accept(c2);
        n2.accept(c3);
        n2.accept(c4);

        ArrayList<Creature> tileNeighings = tile.getNeighingCreatures();
        assertFalse(tileNeighings.contains(c1));
        assertTrue(tileNeighings.contains(c2));
        assertTrue(tileNeighings.contains(c3));
        assertTrue(tileNeighings.contains(c4));

        ArrayList<Creature> n1Neighings = n1.getNeighingCreatures();
        assertTrue(n1Neighings.contains(c1));
        assertFalse(n1Neighings.contains(c2));
        assertFalse(n1Neighings.contains(c3));
        assertFalse(n1Neighings.contains(c4));

        ArrayList<Creature> n2Neighings = n1.getNeighingCreatures();
        assertTrue(n2Neighings.contains(c1));
        assertFalse(n2Neighings.contains(c2));
        assertFalse(n2Neighings.contains(c3));
        assertFalse(n2Neighings.contains(c4));
    }
}