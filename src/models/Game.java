package models;


import exceptions.InvalidMoveException;
import models.pieces.Piece;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    private final Queue<Player> players;
    private final Board board;
    private final Scanner scanner = new Scanner(System.in);
    
    public Game(int size) {
        players = new LinkedList<>();
        players.add(new Player(Color.WHITE));
        players.add(new Player(Color.BLACK));
        board = new Board(size);
    }
    
    public void play() {
        while (true) {
            Player player = players.peek();
            try {
                int sourceRow = scanner.nextInt();
                int sourceCol = scanner.nextInt();
                int destinationRow = scanner.nextInt();
                int destinationCol = scanner.nextInt();
                Color playerColor = player.getColor();
                Piece sourcePiece = board.getBoard().get(sourceRow).get(sourceCol).getPiece();
                Color pieceColor = sourcePiece.getColor();
                if (pieceColor != playerColor) throw new InvalidMoveException();
                sourcePiece.getMove().move(board, new Position(sourceRow, sourceCol), new Position(destinationRow, destinationCol));
                players.poll();
                players.add(player);
            } catch (InvalidMoveException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
