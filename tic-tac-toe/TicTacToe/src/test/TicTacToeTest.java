package test;

import main.models.*;
import org.junit.jupiter.api.Test;
import strategies.playing.RandomPlayingStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {
    private static final int BOARD_SIZE = 3; // Screaming case

    @Test
    public void testCreateGame() {
        // Board board = new Board(BOARD_SIZE);
        // Player humanPlayer = new HumanPlayer(GameSymbol.O, new User());
        // Player botPlayer = new BotPlayer(GameSymbol.O, GameLevel.EASY, new RandomPlayingStrategy());
        // Game game = new Game(board, List.of(humanPlayer, botPlayer), GameStatus.IN_PROGRESS);

        // This process is too lengthy to create a Game, let's use Builder pattern in Game Class

        Game game = Game.builder()
                .withSize(BOARD_SIZE)
                .withPlayer(
                        HumanPlayer.builder()
                                .symbol(GameSymbol.O)
                                .user(new User())
                                .build()
                )
                .withPlayer(
                        BotPlayer.builder()
                                .symbol(GameSymbol.X)
                                .level(GameLevel.EASY)
                                .playingStrategy(new RandomPlayingStrategy())
                                .build()
                )
                .build();

        assertEquals(2, game.getPlayers().size(),
        "If the game is created, it should have 2 players");


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
