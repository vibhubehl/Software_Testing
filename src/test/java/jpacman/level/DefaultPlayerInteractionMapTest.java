package jpacman.level;

import static org.mockito.Mockito.*;

import jpacman.board.Square;
import jpacman.board.Unit;
import jpacman.npc.Ghost;
import jpacman.game.Game;
import jpacman.points.PointCalculatorLoader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultPlayerInteractionMapTest {

    private DefaultPlayerInteractionMap dpim_object;
    private Unit unit_object = mock(Unit.class);
    private Player player_object;
    private Ghost ghost_object;
    private Pellet pellet_object;
    private Game game_object;
    private Square square_object;
    private PointCalculatorLoader point_object;


    @BeforeEach
    private void setup(){
        unit_object = mock(Unit.class);
        pellet_object = mock(Pellet.class);
        player_object = mock(Player.class);
        ghost_object = mock(Ghost.class);
        game_object = mock(Game.class);
        square_object = mock(Square.class);
        point_object = new PointCalculatorLoader();
        dpim_object = new DefaultPlayerInteractionMap(point_object.load());
    }




    @Test
    /*
        tests the collision of player and ghost
        expects player to be dead and ghost to be
        declared the killer and no points changed
     */
    void player_ghost_COL() {
        dpim_object.collide(player_object, ghost_object);
        verify(player_object).setAlive(false);
        verify(player_object).setKiller(ghost_object);
        verify(player_object, never()).addPoints(anyInt());

    }




    @Test
    /*
        tests the collision of ghost and player
        expects player to be dead and ghost to be
        declared the killer and no points changes
     */
    void ghost_player_COL() {
        dpim_object.collide(ghost_object, player_object);
        verify(player_object).setAlive(false);
        verify(player_object).setKiller(ghost_object);
        verify(player_object, never()).addPoints(anyInt());
    }




    @Test
    /*
        tests the collision of ghost and ghost
        expects nothing to happen
     */
    void ghost_ghost_COL(){

        Ghost ghost_object2;
        ghost_object2 = mock(Ghost.class);

        dpim_object.collide(ghost_object, ghost_object2);

        // checking to see nothing happens
        verifyZeroInteractions(ghost_object2);
        verifyZeroInteractions(ghost_object);
    }


    @Test
    /*
        tests the collision of ghost and pellets
        expects nothing to happen
     */
    void ghost_pellet_COL(){

        dpim_object.collide(ghost_object, pellet_object);

        // checking to see nothing happens
        verifyZeroInteractions(pellet_object);
        verifyZeroInteractions(ghost_object);
    }




    @Test
    /*
        tests the collision of pellet and ghost
        expects nothing to happen
     */
    void pellet_ghost_COL(){

        dpim_object.collide(pellet_object, ghost_object);

        // checking to see nothing happens
        verifyZeroInteractions(pellet_object);
        verifyZeroInteractions(ghost_object);
    }




    @Test
    /*
        tests the collision of ghost and ghost
        expects points to be added and pellet to vaccate
        the square
     */
    void player_pellet_COL(){

        // in a normal case 10 points are increased but here we are returning 557
        when(pellet_object.getValue()).thenReturn(577);
        dpim_object.collide(player_object, pellet_object);

        verify(pellet_object).leaveSquare();
        verify(player_object).addPoints(577);
    }



    @Test
    /*
        tests the collision of ghost and ghost
        expects points to be added and pellet to vaccate
        the square
     */
    void pellet_player_COL(){

        // in a normal case 10 points are increased but here we are returning 557
        when(pellet_object.getValue()).thenReturn(577);
        dpim_object.collide(pellet_object, player_object);

        verify(pellet_object).leaveSquare();
        verify(player_object).addPoints(577);
    }



}
