package sumatra;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class PlayerAbilityTest {

    @Test
    public void useAbility_eskimo(){
        Tile t = mock(Tile.class);
        Eskimo e = spy(new Eskimo(t, 0));

        e.useAbility(t);

        verify(t).setBuilding(any(Igloo.class));
        verify(e).decreaseMana();
    }

    @Test
    public void useAbility_eskimo_noMana(){
        Tile t = mock(Tile.class);
        Eskimo e = new Eskimo(t, 0);
        e.mana = 0;

        e.useAbility(t);

        verify(t, never()).setBuilding(any(Igloo.class));
    }

    @Test
    public void useAbility_researcher(){
        Tile t = mock(Tile.class);
        Researcher r = spy(new Researcher(t, 0));

        r.useAbility(t);

        verify(t).revealCapacity();
        verify(r).decreaseMana();
    }

    @Test
    public void useAbility_researcher_noMana(){
        Tile t = mock(Tile.class);
        Researcher r = new Researcher(t, 0);
        r.mana = 0;

        r.useAbility(t);

        verify(t, never()).revealCapacity();
    }

}
