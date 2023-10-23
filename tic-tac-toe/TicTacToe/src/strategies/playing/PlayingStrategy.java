package strategies.playing;

import main.models.Board;
import main.models.BoardCell;

public interface PlayingStrategy {
    BoardCell makeMove(Board board);
}
