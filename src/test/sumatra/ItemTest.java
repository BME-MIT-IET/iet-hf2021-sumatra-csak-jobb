package sumatra;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ItemTest {

    @Test
    public void giveBasicRope(){
        Player p = mock(Player.class);
        Rope r = new BasicRope();

        r.giveToPlayer(p);

        verify(p).addRope(r);
    }

    @Test
    public void giveBasicDivingSuit(){
        Player p = mock(Player.class);
        DivingSuit s = new BasicDivingSuit();

        s.giveToPlayer(p);

        verify(p).addDivingSuit(s);
    }

    @Test
    public void giveFood(){
        Player p = mock(Player.class);
        int heal = 2;
        Food f = new Food(heal);

        f.giveToPlayer(p);

        verify(p).heal(heal);
    }

    @Test
    public void giveUsableItem(){
        Player p = mock(Player.class);
        UsableItem i = new UsableItem() {
            @Override public void use(Tile t) { }
        };

        i.giveToPlayer(p);

        verify(p).addUsableItem(i);
    }

    @Test
    public void useUsableItem(){
        Tile t = mock(Tile.class);
        Player p = new Researcher(t, 0);
        UsableItem i = mock(UsableItem.class);
        p.addUsableItem(i);

        p.useItem(0, t);

        verify(i).use(t);
    }

    @Test
    public void useBasicRope(){
        Tile t1 = new Tile(0, 0);
        Tile t2 = new Tile(1, 0);
        Player p1 = new Researcher(t1, 0);
        Player p2 = new Eskimo(t2, 1);
        t1.accept(p1);
        t2.accept(p2);
        Rope r = new BasicRope();
        r.giveToPlayer(p2);

        r.save(p1, p1.getTile(), p2.getTile());

        assertEquals(t2, p1.getTile());
        assertEquals(t2, p2.getTile());
        assertTrue(t2.creatures.contains(p1));
        assertTrue(t2.creatures.contains(p2));
        assertFalse(t1.creatures.contains(p1));
        assertFalse(t1.creatures.contains(p2));
    }

    @Test
    public void useBrokenShovel(){
        Tile t = mock(Tile.class);
        int maxUse = 3;
        BrokenShovel s = new BrokenShovel(maxUse);

        int uses = 10;
        for(int i = 0; i < uses; i++)
            s.use(t);

        verify(t, times(maxUse)).removeSnow(2);
    }

    @Test
    public void useShovel(){
        Tile t = mock(Tile.class);
        Player p = new Researcher(t, 0);
        Shovel s = new Shovel();
        s.giveToPlayer(p);

        int uses = 10;
        for(int i = 0; i < uses; i++)
            s.use(t);

        verify(t, times(uses)).removeSnow(2);
        assertTrue(p.getItems().contains(s));
    }

    @Test
    public void useTentEquipment(){
        Tile t = mock(Tile.class);
        Player p = new Eskimo(t, 0);
        TentEquipment e = new TentEquipment();
        e.giveToPlayer(p);

        e.use(t);

        verify(t).setBuilding(any(Tent.class));
        assertFalse(p.getItems().contains(e));
    }

}
