package sumatra;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class UnstableTileTest {

    @Test
    void unstableTile_flip(){
        UnstableTile tile = new UnstableTile(0,0,0);
        Player mockPlayer = mock(Player.class);
        tile.accept(mockPlayer);
        verify(mockPlayer, times(1)).fallInWater();
    }

    @Test
    void unstableTile_noFlip(){
        UnstableTile tile = new UnstableTile(0,0,1);
        Player mockPlayer = mock(Player.class);
        tile.accept(mockPlayer);
        verify(mockPlayer, never()).fallInWater();
    }
}
