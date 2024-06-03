package exceptions;

public class InvalidMoveException extends IllegalArgumentException{
    public InvalidMoveException() {
        super("Invalid move");
    }
}
