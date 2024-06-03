package factories;

import models.Color;
import models.moves.Move;
import models.pieces.Piece;
import models.pieces.Rook;

public class RookFactory implements PieceFactory{
    @Override
    public Piece createPiece(Color color, Move move) {
        return new Rook(color, move);
    }
}
