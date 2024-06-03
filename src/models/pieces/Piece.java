package models.pieces;

import models.Color;
import models.moves.Move;

public abstract class Piece {
    protected Color color;
    protected Move move;

    public Piece(Color color, Move move) {
        this.color = color;
        this.move = move;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "color=" + color +
                ", move=" + move +
                '}';
    }
}
