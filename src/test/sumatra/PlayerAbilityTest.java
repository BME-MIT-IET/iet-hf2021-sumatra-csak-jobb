package sumatra;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class PlayerAbilityTest {

    @Test
    public void useAbility_eskimo(){
        Tile t = mock(Tile.class);
        Eskimo e = new Eskimo(t, 0);

        e.useAbility(t);

        verify(t).setBuilding(any(Igloo.class));
    }

    @Test
    public void useAbility_researcher(){
        Tile t = mock(Tile.class);
        Researcher r = new Researcher(t, 0);

        r.useAbility(t);

        verify(t).revealCapacity();
    }

}
