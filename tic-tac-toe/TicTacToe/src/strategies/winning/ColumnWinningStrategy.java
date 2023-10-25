package strategies.winning;

import main.models.Board;
import main.models.GameSymbol;

public class ColumnWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, GameSymbol currentSymbol) {
        for (int i = 0; i < board.getCells().get(0).size(); i++) {
            boolean isWinner = true;
            for (int j = 0; j < board.getCells().size(); j++) {
                if (board.getBoardCell(j, i).getSymbol() != currentSymbol) {
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
