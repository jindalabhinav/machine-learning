package strategies.playing;

import main.models.Board;
import main.models.BoardCell;
import main.models.GameSymbol;

public interface PlayingStrategy {
    BoardCell makeMove(Board board);
}
