package jpacman.integration.suspension;

import jpacman.Launcher;
import jpacman.game.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SuspendSystemTest{

    private Launcher launcher;

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
     * The simplest test that just starts the
     * game, uspends it and checks it is indeed in progress.
     */
    @Test
    public void gameSuspension() {
        launcher.launch();
        getGame().start();
        getGame().stop();
        assertThat(getGame().isInProgress()).isFalse();
    }



    /**
     * The simplest test that just starts the
     * game, uspends it and checks it is indeed in progress.
     */
    @Test
    public void gamerestart() {
        launcher.launch();
        getGame().start();
        getGame().stop();
        getGame().start();
        assertThat(getGame().isInProgress()).isTrue();
    }



    private Game getGame() {
        return launcher.getGame();
    }
}
