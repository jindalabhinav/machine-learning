package exceptions;

public class InvalidBoardException extends RuntimeException {
    public InvalidBoardException() {
        super("Board size cannot be lesser than 2!");
    }
}
