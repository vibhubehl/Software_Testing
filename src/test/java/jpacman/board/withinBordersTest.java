package jpacman.board;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;


public class withinBordersTest {

    private final Square[][] grid = {
            { mock(Square.class), mock(Square.class), mock(Square.class) },
            { mock(Square.class), mock(Square.class), mock(Square.class) },
    };
    private final Board board = new Board(grid);

    /**
     * Verify that the  following co-oordinates are on board
     * @param x Horizontal coordinate of relevant cell.
     * @param y Vertical coordinate of relevant cell.
     */
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "1, 0",
            "0, 1"
    })
    void test_on_square(int x, int y) {
        assertThat(board.withinBorders(x, y)).isTrue();
    }

    /**
     * Verify that the  following co-oordinates are not on board
     * @param x Horizontal coordinate of relevant cell.
     * @param y Vertical coordinate of relevant cell.
     */
    @ParameterizedTest
    @CsvSource({
            "4, 4",
            "-1, -1",
            "-1, 0",
            "0, -1"
    })
    void test_not_on_square(int x, int y) {
        assertThat(board.withinBorders(x, y)).isFalse();
    }

}
