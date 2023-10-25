package strategies.winning;

import main.models.Board;
import main.models.GameSymbol;

public class DiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, GameSymbol currentSymbol) {
        if (checkFirstDiagonal(board, currentSymbol))
            return true;

        if (checkSecondDiagonal(board, currentSymbol))
            return true;

        return false;
    }

    private static boolean checkFirstDiagonal(Board board, GameSymbol currentSymbol) {
        boolean isWinner = true;
        for (int j = 0; j < board.getSize(); j++) {
            if (board.getBoardCell(j, j).getSymbol() != currentSymbol) {
                isWinner = false;
                break;
            }
        }
        if (isWinner)
            return true;
        return false;
    }

    private static boolean checkSecondDiagonal(Board board, GameSymbol currentSymbol) {
        boolean isWinner = true;
        int x = 0, y = board.getSize() - 1;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getBoardCell(x++, y--).getSymbol() != currentSymbol) {
                isWinner = false;
                break;
            }
        }
        if (isWinner)
            return true;
        return false;
    }
}
