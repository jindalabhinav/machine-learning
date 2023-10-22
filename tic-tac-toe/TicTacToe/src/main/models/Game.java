package main.models;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Game {
    private Board board;

    // we always initialize our collections to not run into null-pointer exceptions
    // instead of having low-level dependency on Human/Bot Player, we depend upon Player, which gives us loose coupling and is an example of dependency inversion
    private List<Player> players = new ArrayList<>();
    private GameStatus status;

    public void start() {}

    public void makeMove() {}

    public Player checkWinner() {
        return null;
    }

    public boolean checkDrawn() {
        return false;
    }
}
