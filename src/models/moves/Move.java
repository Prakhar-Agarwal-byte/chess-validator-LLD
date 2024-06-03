package models.moves;

import models.Board;
import models.Position;

public interface Move {
    void move(Board board, Position curPosition, Position destPosition);
}
