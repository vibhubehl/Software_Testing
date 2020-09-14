package jpacman.points;

import jpacman.npc.Ghost;
import jpacman.board.Direction;
import jpacman.level.Pellet;
import jpacman.level.Player;

/**
 * A simple, minimalistic point calculator just
 * adding points for each pellet consumed.
 */
public class DefaultPointCalculator implements PointCalculator {

    @Override
    public void collidedWithAGhost(Player player, Ghost ghost) {
        // no points for colliding with a ghost
    }

    @Override
    public void consumedAPellet(Player player, Pellet pellet) {
        player.addPoints(pellet.getValue());
    }

    @Override
    public void pacmanMoved(Player player, Direction direction) {
        // no points for moving
    }
}
