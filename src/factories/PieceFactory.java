package factories;

import models.Color;
import models.moves.Move;
import models.pieces.Piece;

public interface PieceFactory {
    Piece createPiece(Color color, Move move);
}
