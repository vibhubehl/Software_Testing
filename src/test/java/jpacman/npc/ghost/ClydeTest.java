package jpacman.npc.ghost;

import java.util.Optional;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

import jpacman.board.BoardFactory;
import jpacman.board.Direction;
import jpacman.level.LevelFactory;
import jpacman.level.Player;
import jpacman.level.PlayerFactory;
import jpacman.points.PointCalculatorLoader;
import jpacman.sprite.PacManSprites;
import jpacman.level.Level;
import org.junit.jupiter.api.Test;


public class ClydeTest {
    public GhostFactory gfactory;
    public PlayerFactory pfactory;
    public BoardFactory bfactory;
    public PointCalculatorLoader PCL;
    public LevelFactory lFactory;
    public GhostMapParser mapP;
    public Level level;

    public ClydeTest(){
        PacManSprites pc_sprites = new PacManSprites();
        gfactory = new GhostFactory(pc_sprites);
        pfactory = new PlayerFactory(pc_sprites);
        bfactory = new BoardFactory(pc_sprites);
        PCL = new PointCalculatorLoader();
        lFactory = new LevelFactory(pc_sprites, gfactory, PCL.load());
        mapP = new GhostMapParser(lFactory, bfactory, gfactory);
    }

    @Test
    // This test case checks for case where there is no player.
    void test_away_NP(){

    level = mapP.parseMap(Arrays.asList("##############", "#           #C", "##############"));
    Clyde object = Navigation.findUnitInBoard(Clyde.class, level.getBoard());
    assertThat(object.nextAiMove()).isEqualTo(Optional.empty());
    }

    @Test
    // This test case checks for case where there is player more than 8 blocks away.
    void test_away_P(){

        level = mapP.parseMap(Arrays.asList("##############", "#C          P#", "##############"));
        Player test_player = pfactory.createPacMan();
        level.registerPlayer(test_player);
        test_player.setDirection(Direction.EAST);
        Clyde object = Navigation.findUnitInBoard(Clyde.class, level.getBoard());
        assertThat(object.nextAiMove()).isEqualTo(Optional.of(Direction.EAST));
    }


    @Test
    // This test case checks for case where there is player less than 8 blocks away.
    void test_near_P(){

        level = mapP.parseMap(Arrays.asList("##############", "#C  P        #", "##############"));
        Player test_player = pfactory.createPacMan();
        level.registerPlayer(test_player);
        test_player.setDirection(Direction.EAST);
        Clyde object = Navigation.findUnitInBoard(Clyde.class, level.getBoard());
        assertThat(object.nextAiMove()).isEqualTo(Optional.of(Direction.WEST));
    }


}
