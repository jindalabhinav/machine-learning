package exceptions;

public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException(int row, int column) {
        super("This move was invalid: " + row + "," + column);
    }
}
