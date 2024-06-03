package models.moves;

import exceptions.InvalidMoveException;
import models.Board;
import models.Cell;
import models.Position;
import models.pieces.Pawn;
import models.pieces.Piece;

public class PawnMove implements Move{
    @Override
    public void move(Board board, Position curPosition, Position destPosition) {
        int curRow = curPosition.getRow();
        int curCol = curPosition.getCol();
        Cell curCell = board.getBoard().get(curRow).get(curCol);
        int destRow = destPosition.getRow();
        int destCol = destPosition.getCol();
        Piece curPiece = board.getBoard().get(curRow).get(curCol).getPiece();
        if (curPiece == null) throw new InvalidMoveException();
        if (!(curPiece instanceof Pawn)) throw new InvalidMoveException();
        Pawn curPawn = (Pawn) curPiece;
        Piece destPiece = board.getBoard().get(destRow).get(destCol).getPiece();
        if (destPiece != null) {
            if (destPiece.getColor() == curPawn.getColor()) throw new InvalidMoveException();
            int[] r = {-1, -1};
            int[] c = {-1, 1};
            for (int i = 0; i < 2; i++) {
                int rr = curRow + r[i];
                int cc = curCol + c[i];
                if (destRow == rr && destCol == cc) {
                    Cell destCell = board.getBoard().get(rr).get(cc);
                    destCell.setPiece(curPawn);
                    curCell.setPiece(null);
                    curPawn.setFirstMove(false);
                    return;
                }
            }
        }
        int rr = curRow - 1;
        int cc = curCol;
        if (destRow == rr && destCol == cc) {
            Cell destCell = board.getBoard().get(rr).get(cc);
            destCell.setPiece(curPawn);
            curCell.setPiece(null);
            curPawn.setFirstMove(false);
            return;
        }
        if (curPawn.isFirstMove()) {
            rr = curRow - 1;
            cc = curCol;
            Cell destCell = board.getBoard().get(rr).get(cc);
            if (destCell.getPiece() != null) return;
            rr = curRow - 2;
            if (destRow == rr && destCol == cc) {
                destCell = board.getBoard().get(rr).get(cc);
                destCell.setPiece(curPawn);
                curCell.setPiece(null);
                curPawn.setFirstMove(false);
                return;
            }
            curPawn.setFirstMove(false);
        }
    }
}
