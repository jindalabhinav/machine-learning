package strategies.winning;

import main.models.Board;
import main.models.GameSymbol;

public interface WinningStrategy {
    boolean checkWinner(Board board, GameSymbol currentSymbol);
}
