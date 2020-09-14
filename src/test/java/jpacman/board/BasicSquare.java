package jpacman.board;

import jpacman.board.Square;
import jpacman.board.Unit;
import jpacman.sprite.Sprite;

/**
 * Basic implementation of square.
 *
 * @author Jeroen Roosen 
 */
class BasicSquare extends Square {

    /**
     * Creates a new basic square.
     */
    BasicSquare() {
        super();
    }

    @Override
    public boolean isAccessibleTo(Unit unit) {
        return true;
    }

    @Override
    @SuppressWarnings("return.type.incompatible")
    public Sprite getSprite() {
        return null;
    }
}
