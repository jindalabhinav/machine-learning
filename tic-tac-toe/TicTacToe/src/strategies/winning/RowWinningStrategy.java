package strategies.winning;

import main.models.Board;
import main.models.BoardCell;
import main.models.GameSymbol;

import java.util.List;

public class RowWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, GameSymbol currentSymbol) {
        for (List<BoardCell> row : board.getCells()) {
            boolean isWinner = true;
            for (BoardCell cell : row) {
                if (cell.getSymbol() != currentSymbol) {
                    isWinner = false;
                    break;
                }
            }
            if (isWinner)
                return true;
        }

        return false;
    }
}
