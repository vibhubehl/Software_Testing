package jpacman.npc.ghost;

import jpacman.board.BoardFactory;
import jpacman.board.Square;
import jpacman.level.LevelFactory;
import jpacman.level.MapParser;
import jpacman.npc.Ghost;
import jpacman.npc.ghost.GhostFactory;

import java.util.List;

/**
 * A test helper utility for writing the ghost unit tests.
 * A useful method for retrieving ghosts from your map would be:
 * findUnitInBoard in the Navigation class.
 */
public final class GhostMapParser extends MapParser {
    private final GhostFactory ghostFactory;

    /**
     * Creates a new enhanced map parser.
     * This map parser allows users to specify which ghost should be placed
     * at an exact location.
     *
     * @param levelFactory The factory providing the NPC objects and the level.
     * @param boardFactory The factory to create board elements.
     * @param ghostFactory the factory to create the ghosts.
     */
    public GhostMapParser(LevelFactory levelFactory, BoardFactory boardFactory,
                          GhostFactory ghostFactory) {
        super(levelFactory, boardFactory);
        this.ghostFactory = ghostFactory;
    }

    //This method only supports clyde for now
    //You should add extra cases for ghosts you need.
    @Override
    protected void addSquare(Square[][] grid, List<Ghost> ghosts,
                             List<Square> startPositions, int x, int y, char c) {
        switch (c) {
            case 'C':
                grid[x][y] = makeGhostSquare(ghosts, ghostFactory.createClyde());
                break;
            default:
                super.addSquare(grid, ghosts, startPositions, x, y, c);
        }
    }
}
