package sumatra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

public class BuildingTest {

    @Test
    public void build(){
        Tile t = new Tile(0, 1);
        Building b = mock(Building.class);
        t.setBuilding(b);
        assertEquals(b, t.getBuilding());
    }

    @Test
    public void build_onUnstableTile(){
        UnstableTile u = new UnstableTile(0, 1, 1);
        Building b = mock(Building.class);
        u.setBuilding(b);
        assertEquals(b, u.getBuilding());
    }

    @Test
    public void build_onHole(){
        HoleTile h = new HoleTile(0, 1);
        Building b = mock(Building.class);
        h.setBuilding(b);
        assertNotEquals(b, h.getBuilding());
    }

    @Test
    public void destroyTent(){
        Tile t = mock(Tile.class);
        Tent tent = new Tent(t);
        tent.destroy();
        verify(t).setBuilding(any(NoBuilding.class));
    }

    @Nested
    class SnowstormTest {

        private Tile t;
        private Player p;

        @BeforeEach
        public void init(){
            t = new Tile(0, 0);
            p = mock(Player.class);
            t.accept(p);
        }

        @Test
        public void snowstorm_noBuilding(){
            t.setBuilding(new NoBuilding());
            t.storm();
            verify(p).damage(1);
        }

        @Test
        public void snowstorm_igloo(){
            t.setBuilding(new Igloo());
            t.storm();
            verify(p, never()).damage(anyInt());
        }

        @Test
        public void snowstorm_tent(){
            t.setBuilding(new Tent(t));
            t.storm();
            verify(p, never()).damage(anyInt());
        }
    }

    @Nested
    class NewCreatureTest {

        private Player p;
        private ArrayList<Creature> creatures;
        private Creature newCreature;

        @BeforeEach
        public void init(){
            p = mock(Player.class);
            creatures = new ArrayList<>();
            creatures.add(p);
            newCreature = mock(Creature.class);
        }

        @Test
        public void newCreature_noBuilding(){
            Building none = new NoBuilding();
            none.newCreature(newCreature, creatures);
            verify(p).collideWith(newCreature);
        }

        @Test
        public void newCreature_igloo(){
            Building igloo = new Igloo();
            igloo.newCreature(newCreature, creatures);
            verifyNoInteractions(p, newCreature);
        }

        @Test
        public void newCreature_tent(){
            Building tent = new Tent(mock(Tile.class));
            tent.newCreature(newCreature, creatures);
            verify(p).collideWith(newCreature);
        }
    }

}
