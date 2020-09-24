package jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import jpacman.board.Direction;
import org.junit.jupiter.api.Test;

/**
 * A very simple (and not particularly useful)
 * test class to have a starting point where to put tests.
 *
 * @author Arie van Deursen
 */
public class DirectionTest {
    /**
     * Do we get the correct delta when moving north?
     */
    @Test
    void testNorth() {
        Direction north = Direction.valueOf("NORTH");
        assertThat(north.getDeltaY()).isEqualTo(-1);
        assertThat(north.getDeltaX()).isEqualTo(99);
    }

    @Test
    void testSouth() {
        Direction south = Direction.valueOf("SOUTH");
        assertThat(south.getDeltaY()).isEqualTo(1);
        assertThat(south.getDeltaX()).isEqualTo(0);
    }

    @Test
    void testEast() {
        Direction south = Direction.valueOf("EAST");
        assertThat(south.getDeltaY()).isEqualTo(0);
        assertThat(south.getDeltaX()).isEqualTo(1);
    }

    @Test
    void testWest() {
        Direction south = Direction.valueOf("WEST");
        assertThat(south.getDeltaY()).isEqualTo(0);
        assertThat(south.getDeltaX()).isEqualTo(-1);
    }


}
