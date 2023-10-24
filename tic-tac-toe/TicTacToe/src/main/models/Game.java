package main.models;

import exceptions.InvalidMoveException;
import exceptions.InvalidPlayersException;
import lombok.Getter;
import strategies.winning.RowWinningStrategy;
import strategies.winning.WinningStrategy;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class Game {
    private static final int PLAYER_COUNT = 2;
    private static final GameStatus DEFAULT_STATUS = GameStatus.IN_PROGRESS;
    private Board board;
    // we always initialize our collections to not run into null-pointer exceptions
    // instead of having low-level dependency on Human/Bot Player, we depend upon Player, which gives us loose coupling and is an example of dependency inversion
    private List<Player> players = new ArrayList<>();
    private GameStatus status;
    private int nextPlayerIndex = 0;
    private List<WinningStrategy> winningStrategies = List.of(new RowWinningStrategy());
    private Player winner;

    private Game() {}

    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private Game game;

        private Builder() {
            game = new Game();
        }

        public Builder withSize(int size) {
            this.game.board = new Board(size);
            return this;
        }

        public Builder withPlayer(Player player) {
            this.game.players.add(player);
            return this;
        }

        public Game build() {
            if (!isValid(this.game)) {
                throw new InvalidPlayersException();
            }

            Game newGame = new Game();
            newGame.board = this.game.board;
            newGame.players = this.game.players;
            newGame.status = DEFAULT_STATUS;

            return newGame;
        }

        private boolean isValid(Game game) {
            var players = game.players;
            if (game.board.getSize() < 2 || players.size() != PLAYER_COUNT)
                return false;

            Set<GameSymbol> symbols = players.stream()
                    .map(Player::getSymbol)
                    .collect(Collectors.toSet());
            return symbols.size() == PLAYER_COUNT;
        }
    }

    public void start() {
        // Assign a random value to the nextPlayerIndex
        nextPlayerIndex = (int) (Math.random() * players.size());
    }

    public void makeMove() {
        BoardCell move = getNextMove();

        board.updateBoardCell(move.getRow(), move.getColumn(), move.getSymbol());

        if (checkWinner(move.getSymbol()))
            status = GameStatus.FINISHED;

        if (checkDrawn())
            status = GameStatus.DRAWN;

        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
    }

    private BoardCell getNextMove() {
        Player player = getNextPlayer();
        var move = player.makeMove(board);
        validateMove(move);
        return move;
    }

    public Player getNextPlayer() {
        return players.get(nextPlayerIndex);
    }

    private void validateMove(BoardCell move) {
        int row = move.getRow();
        int col = move.getColumn();
        if (!board.isEmpty(row, col))
            throw new InvalidMoveException(row, col);
    }

    public boolean checkWinner(GameSymbol currentSymbol) {
        for (WinningStrategy winningStrategy : winningStrategies) {
            if (winningStrategy.checkWinner(board, currentSymbol)) {
                winner = getNextPlayer();
                return true;
            }
        }
        return false;
    }

    public boolean checkDrawn() {
        // TODO
        return false;
    }
}
