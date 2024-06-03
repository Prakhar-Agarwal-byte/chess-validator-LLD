package models.pieces;

import models.Color;
import models.moves.Move;

public class Pawn extends Piece{
    private boolean isFirstMove;

    public Pawn(Color color, Move move) {
        super(color, move);
        this.isFirstMove = true;
    }

    public boolean isFirstMove() {
        return isFirstMove;
    }

    public void setFirstMove(boolean firstMove) {
        isFirstMove = firstMove;
    }

    @Override
    public String toString() {
        return "Pawn{" +
                "isFirstMove=" + isFirstMove +
                ", color=" + color +
                ", move=" + move +
                '}';
    }
}
