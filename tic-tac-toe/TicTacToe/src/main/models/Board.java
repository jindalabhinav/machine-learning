package main.models;

import lombok.Getter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@Getter
public class Board {
    private int size;
    private List<List<BoardCell>> cells = new ArrayList<>();

    public Board(int size) {
        this.size = size;
        this.cells = initializeCells(size);
    }

    private List<List<BoardCell>> initializeCells(int size) {
        List<List<BoardCell>> cells = new ArrayList<>();
        IntStream.range(0, size).forEach(row -> {
            List<BoardCell> rowCells = new ArrayList<>();
            IntStream.range(0, size).forEach(column -> rowCells.add(new BoardCell(row, column)));
            cells.add(rowCells);
        });
        return cells;
    }

    public boolean isEmpty(int row, int column) {
        return getBoardCell(row, column).getSymbol() == null;
    }

    public void updateBoardCell(int row, int column, GameSymbol symbol) {
        getBoardCell(row, column).setSymbol(symbol);
    }

    public void updateBoardCell(BoardCell move) {
        int row = move.getRow();;
        int column = move.getColumn();
        BoardCell cell = cells.get(row).get(column);
        cell.setSymbol(move.getSymbol());
    }

    private BoardCell getBoardCell(int row, int column) {
        return cells.get(row).get(column);
    }

    public void printBoard() {
        for (int i = 0; i < cells.size(); i++) {
            for (int j = 0; j < cells.get(i).size(); j++) {
                String value =  cells.get(i).get(j).getSymbol() == null ?
                        "| - |" :
                        ("| " + cells.get(i).get(j).getSymbol().toString() + " |");
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
