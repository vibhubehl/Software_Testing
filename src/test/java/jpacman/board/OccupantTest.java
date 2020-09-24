package jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        // Remove the following placeholder
        assertThat(unit.hasSquare() == false);
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        Square test_sqr = new BasicSquare();

        // add unit to this square
        unit.occupy(test_sqr);

        // check if current unit and squares are associated
        assertThat(unit.invariant());
        assertThat(test_sqr.invariant());

        // get current position
        Square current = unit.getSquare();

        assertThat(current == test_sqr);

    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {

        Direction north = Direction.valueOf("NORTH");
        Square sqr1 = new BasicSquare();
        Square sqr2 = new BasicSquare();
        //sqr2 = sqr1.getSquareAt(north);


        // re-occupying
        unit.occupy(sqr1);
        unit.occupy(sqr2);
        unit.occupy(sqr1);

        // get current position
        Square current = unit.getSquare();
        assertThat(current).isEqualTo(sqr1);

        // re-occupying
        unit.occupy(sqr2);
        unit.occupy(sqr2);

        // get current position
        current = unit.getSquare();
        assertThat(current).isEqualTo(sqr2);
    }
}
