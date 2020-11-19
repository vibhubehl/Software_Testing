package jpacman.integration;

import jpacman.Launcher;
import jpacman.board.Direction;
import jpacman.board.Square;
import jpacman.game.Game;
import jpacman.level.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SystemUsertStoryTest {

    private Launcher launcher;

    private Game getGame() {
        return launcher.getGame();
    }

    /**
     * Start a launcher, which can display the user interface.
     */
    @BeforeEach
    public void before() {
        launcher = new Launcher();
    }

    /**
     * Close the user interface.
     */
    @AfterEach
    public void after() {
        launcher.dispose();
    }

    /**
     *  Tests for the following scenario
     Scenario S2.1: The player consumes
     Given the game has started,
     and  my Pacman is next to a square containing a pellet;
     When  I press an arrow key towards that square;
     Then  my Pacman can move to that square,
     and  I earn the points for the pellet,
     and  the pellet disappears from that square.
     */
    @Test
    public void PlayerPellet(){
        // set map
        launcher.withMapFile("/userstory.txt");
        launcher.launch();
        getGame().start();
        Player player = getGame().getPlayers().get(0);
        getGame().move(player, Direction.EAST );

        Square sqr = getGame().getLevel().getBoard().squareAt(3,1);

        // check score
        assertThat(player.getScore()).isEqualTo(10);
        assertThat(sqr.getOccupants().get(0) instanceof Player).isTrue();
    }





    /**
     *  Tests for the following scenario

     Scenario S2.2: The player moves on empty square
     Given the game has started,
     and  my Pacman is next to an empty square;
     When  I press an arrow key towards that square;
     Then  my Pacman can move to that square
     and  my points remain the same..
     */
    @Test
    public void PlayerEmpty(){
        // set map
        launcher.withMapFile("/userstory.txt");
        launcher.launch();
        getGame().start();
        Player player = getGame().getPlayers().get(0);
        getGame().move(player, Direction.WEST );

        Square sqr = getGame().getLevel().getBoard().squareAt(1,1);

        // check score
        assertThat(player.getScore()).isEqualTo(0);
        assertThat(sqr.getOccupants().get(0) instanceof Player).isTrue();
    }



    /**
     *  Tests for the following scenario

     Scenario S2.3: The move fails
     Given the game has started,
     and my Pacman is next to a cell containing a wall;
     When  I press an arrow key towards that cell;
     Then  the move is not conducted.
     */
    @Test
    public void PlayerWall(){
        // set map
        launcher.withMapFile("/userstory.txt");
        launcher.launch();
        getGame().start();
        Player player = getGame().getPlayers().get(0);
        getGame().move(player, Direction.NORTH );

        Square sqr = getGame().getLevel().getBoard().squareAt(2,1);

        // check score
        assertThat(player.getScore()).isEqualTo(0);
        assertThat(sqr.getOccupants().get(0) instanceof Player).isTrue();
    }
}