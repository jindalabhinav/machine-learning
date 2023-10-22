package test;

import main.models.Board;
import main.models.BoardCell;
import main.models.Game;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {
    @Test
    public void testCreateGame() {


    }

    @Test
    public void testCreateBoard() {
        Board board = new Board(3);

        int rowSize = board.getCells().size();
        assertEquals(3, rowSize,
                "if the ctor of Board is called with n, it should create n rows");

        int columnSize = board.getCells().get(0).size();
        assertEquals(3, columnSize,
                "if the ctor of Board is called with n, it should create n columns");
    }

}
