import main.models.*;
import strategies.playing.RandomPlayingStrategy;

import java.nio.file.attribute.FileAttribute;
import java.util.Scanner;

public class TicTacToe {
    private static final int BOARD_SIZE = 3;
    public static void main(String[] args) {
        // Ask for user input - name, email, symbol
        var humanPlayer = getUserInput();
        System.out.println("Human player symbol: " + humanPlayer.getSymbol());

        // Create a Game
        Game game = createGame(humanPlayer);

        // Start the game
        game.start();

        // Continue until win or drawn
        while (game.getStatus() == GameStatus.IN_PROGRESS) {
            Player player = game.getNextPlayer();
            System.out.println("Next Player: " + player.getClass().getSimpleName() + ", Symbol: " + player.getSymbol());
            game.makeMove();
            game.getBoard().printBoard();
        }

        // Print the winner
        if (game.getStatus() == GameStatus.FINISHED) {
            System.out.println("Winner of the game is: " + game.getWinner().getClass().getSimpleName());
        }
    }

    private static Game createGame(HumanPlayer humanPlayer) {
        /*
        TODO:
        Take input for BOARD_SIZE
        Take input for a Game Type
            H vs B
            H vs H
         */
        return Game.builder()
                .withSize(BOARD_SIZE)
                .withPlayer(humanPlayer)
                .withPlayer(
                        BotPlayer.builder()
                                .level(GameLevel.EASY)
                                .symbol(decideBotSymbol(humanPlayer))
                                .playingStrategy(new RandomPlayingStrategy())
                                .build()
                )
                .build();
    }

    private static GameSymbol decideBotSymbol(HumanPlayer humanPlayer) {
        return humanPlayer.getSymbol() == GameSymbol.O ? GameSymbol.X : GameSymbol.O;
    }

    private static HumanPlayer getUserInput() {
        System.out.println("Welcome to TicTacToe");
        User user = new User();

        System.out.println("Enter name");
        Scanner scanner = new Scanner(System.in);
        user.setName(scanner.nextLine());

        System.out.println("Enter email");
        user.setEmail(scanner.nextLine());

        System.out.println("Enter symbol");
        GameSymbol humanSymbol = null;
        while (humanSymbol == null) {
            try {
                humanSymbol = GameSymbol.valueOf(scanner.nextLine());
            }
            catch (IllegalArgumentException ex) {
                System.out.println("Wrong Input, Enter X or O.");
            }
        }

        return new HumanPlayer(humanSymbol, user);
    }
}