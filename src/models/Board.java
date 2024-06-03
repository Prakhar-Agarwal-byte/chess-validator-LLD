package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;
    private int size;

    public Board(int size) {
        this.size = size;
        List<List<Cell>> board = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ArrayList<Cell> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(new Cell(null));
            }
            board.add(row);
        }
        this.board = board;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + board +
                ", size=" + size +
                '}';
    }
}
