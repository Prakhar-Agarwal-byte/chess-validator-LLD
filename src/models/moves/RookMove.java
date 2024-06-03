package models.moves;

import exceptions.InvalidMoveException;
import models.Board;
import models.Cell;
import models.Position;
import models.pieces.Pawn;
import models.pieces.Piece;
import models.pieces.Rook;

public class RookMove implements Move{
    @Override
    public void move(Board board, Position curPosition, Position destPosition) {
        int boardSize = board.getSize();
        int curRow = curPosition.getRow();
        int curCol = curPosition.getCol();
        Cell startCell = board.getBoard().get(curRow).get(curCol);
        int destRow = destPosition.getRow();
        int destCol = destPosition.getCol();
        Piece curPiece = board.getBoard().get(curRow).get(curCol).getPiece();
        if (curPiece == null) throw new InvalidMoveException();
        if (!(curPiece instanceof Rook)) throw new InvalidMoveException();
        Rook curRook = (Rook) curPiece;
        Piece destPiece = board.getBoard().get(destRow).get(destCol).getPiece();
        if (destPiece != null) {
            if (destPiece.getColor() == curRook.getColor()) throw new InvalidMoveException();
        }
        for (int i = curRow-1; i >= 0; i--) {
            int rr = i;
            int cc = curCol;
            Cell curCell = board.getBoard().get(rr).get(cc);
            if (destRow == rr && destCol == cc) {
                Cell destCell = board.getBoard().get(rr).get(cc);
                destCell.setPiece(curRook);
                startCell.setPiece(null);
                return;
            }
            if (curCell.getPiece() != null) break;
        }
        for (int i = curCol+1; i < boardSize; i++) {
            int rr = curRow;
            int cc = i;
            Cell curCell = board.getBoard().get(rr).get(cc);
            if (destRow == rr && destCol == cc) {
                Cell destCell = board.getBoard().get(rr).get(cc);
                destCell.setPiece(curRook);
                startCell.setPiece(null);
                return;
            }
            if (curCell.getPiece() != null) break;
        }
        for (int i = curRow+1; i < boardSize; i++) {
            int rr = i;
            int cc = curCol;
            Cell curCell = board.getBoard().get(rr).get(cc);
            if (destRow == rr && destCol == cc) {
                Cell destCell = board.getBoard().get(rr).get(cc);
                destCell.setPiece(curRook);
                startCell.setPiece(null);
                return;
            }
            if (curCell.getPiece() != null) break;
        }
        for (int i = curCol - 1; i >= 0; i--) {
            int rr = curRow;
            int cc = i;
            Cell curCell = board.getBoard().get(rr).get(cc);
            if (destRow == rr && destCol == cc) {
                Cell destCell = board.getBoard().get(rr).get(cc);
                destCell.setPiece(curRook);
                startCell.setPiece(null);
                return;
            }
            if (curCell.getPiece() != null) break;
        }
    }
}
