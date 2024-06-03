package factories;

import models.Color;
import models.moves.Move;
import models.pieces.Pawn;
import models.pieces.Piece;

public class PawnFactory implements PieceFactory{
    @Override
    public Piece createPiece(Color color, Move move) {
        return new Pawn(color, move);
    }
}
