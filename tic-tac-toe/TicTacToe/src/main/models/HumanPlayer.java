package main.models;

import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.util.Scanner;

// Extrinsic State
@SuperBuilder
public class HumanPlayer extends Player {
    private User user;

    public HumanPlayer(GameSymbol symbol, User user) {
        super(symbol);
        this.user = user;
    }

    @Override
    public BoardCell makeMove(Board board) {
        System.out.println("Enter row and column");
        var scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        return new BoardCell(row - 1, column - 1, getSymbol());
    }
}
