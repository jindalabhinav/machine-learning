package strategies.playing;

import main.models.Board;
import main.models.BoardCell;

import java.util.List;

public class RandomPlayingStrategy implements PlayingStrategy {
    @Override
    public BoardCell makeMove(Board board) {
        List<BoardCell> emptyCells = board.getEmptyCells();
        int randomIndex = (int) (Math.random() * emptyCells.size());
        BoardCell selectedCell = emptyCells.get(randomIndex);
        BoardCell boardCell = new BoardCell(selectedCell.getRow(), selectedCell.getColumn());
        return boardCell;
    }
}
