package jpacman.game;


import jpacman.Launcher;
import jpacman.board.Direction;
import jpacman.board.Square;
import jpacman.game.Game;
import jpacman.level.Player;
import jpacman.npc.Ghost;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

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


    /*  Transition from In progress to In progress
        on player pellet collision tested
     */
    @Test
    public void PlayerPellet(){
        // set map
        launcher.withMapFile("/userstory.txt");
        launcher.launch();

        // game in progress
        getGame().start();
        Player player = getGame().getPlayers().get(0);
        getGame().move(player, Direction.EAST );

        Square sqr = getGame().getLevel().getBoard().squareAt(3,1);

        // check score
        assertThat(player.getScore()).isEqualTo(10);
        assertThat(sqr.getOccupants().get(0) instanceof Player).isTrue();

        // check game is in progress
        assertThat(getGame().isInProgress()).isTrue();
    }

    /*  Transition from In progress to Game Lost
        on player ghost collision tested
     */

    @Test
    public void PlayerGhost(){
        // set map
        launcher.withMapFile("/winning_ghost.txt");
        launcher.launch();


        getGame().start();

        // check game is in progress
        assertThat(getGame().isInProgress()).isTrue();

        // make player collide with ghost
        Player player = getGame().getPlayers().get(0);
        getGame().move(player, Direction.WEST );

        Square sqr = getGame().getLevel().getBoard().squareAt(1,1);

        // Game lost state consists player being dead, score 0
        // and game being stopped
        assertThat( getGame().isInProgress() ).isFalse();
        assertThat( getGame().getPlayers().get(0).isAlive()).isFalse();
        assertThat(player.getScore()).isEqualTo(0);

    }

    /*  Transition from In progress to Moves Suspended when stop is clicked
     */
    @Test
    public void IP_2_movesSuspend() {
        launcher.withMapFile("/userstory.txt");
        launcher.launch();
        getGame().start();
        getGame().stop();

        // check game is stopped
        assertThat(getGame().isInProgress()).isFalse();

        //push new moves
        Player player = getGame().getPlayers().get(0);
        getGame().move(player, Direction.EAST );

        // any moves now are suspended
        Square sqr = getGame().getLevel().getBoard().squareAt(2,1);
        assertThat(sqr.getOccupants().get(0) instanceof Player).isTrue();

    }


    /*  Transition from In progress to Game Won when last pellet is eaten.
     */
    @Test
    public void IP_2_gameWon(){
        // set map
        launcher.withMapFile("/winning_ghost.txt");
        launcher.launch();
        getGame().start();
        Player player = getGame().getPlayers().get(0);
        getGame().move(player, Direction.EAST );

        Square sqr = getGame().getLevel().getBoard().squareAt(3,1);

        /* Game won state is when where game is stopped
            and player will still be alive. Points are also awarded
            for the last pellet
         */

        // check score incremented by 10 and game is not in progress
        assertThat(player.getScore()).isEqualTo(10);
        assertThat(sqr.getOccupants().get(0) instanceof Player).isTrue();
        assertThat( getGame().isInProgress() ).isFalse();

        //player is alive
        assertThat( getGame().getPlayers().get(0).isAlive()).isTrue();
        assertThat( getGame().getPlayers().get(0).getScore()).isEqualTo(10);

    }

    /*  Transition from Moves Suspended to in progress.
     */
    @Test
    public void movesSuspend_2_IP() {
        launcher.withMapFile("/userstory.txt");
        launcher.launch();
        getGame().start();
        getGame().stop();

        // check game is paused
        assertThat(getGame().isInProgress()).isFalse();

        getGame().start();

        // check game is in progress
        assertThat(getGame().isInProgress()).isTrue();

        //push new moves
        Player player = getGame().getPlayers().get(0);
        getGame().move(player, Direction.EAST );

        // new moves are being pushed
        Square sqr = getGame().getLevel().getBoard().squareAt(3,1);
        assertThat(sqr.getOccupants().get(0) instanceof Player).isTrue();



    }

}
