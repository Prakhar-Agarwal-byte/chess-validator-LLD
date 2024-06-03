package models;

import models.pieces.Piece;

public class Cell {
    private Piece piece;

    public Cell(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "piece=" + piece +
                '}';
    }
}
