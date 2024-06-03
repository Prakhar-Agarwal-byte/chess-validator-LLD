package models.moves;

import models.Board;
import models.Position;
import models.pieces.Piece;

public interface Move {
    void move(Board board, Position curPosition, Position destPosition);
}
