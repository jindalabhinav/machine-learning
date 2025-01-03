import main.models.*;
import strategies.playing.RandomPlayingStrategy;

import java.nio.file.attribute.FileAttribute;
import java.util.Scanner;

public class TicTacToe {
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
            System.out.println(game.getWinner().getClass().getSimpleName() + " Wins!");
        }

        if (game.getStatus() == GameStatus.DRAWN) {
            System.out.println("Game is Drawn");
        }
    }

    private static Game createGame(HumanPlayer humanPlayer) {
        /*
        TODO:
        Take input for a Game Type
            H vs B
            H vs H
         */
        System.out.println("Enter board size");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose Game Difficulty: 1. Easy 2. Medium 3. Hard");
        var gameDifficulty = getGameDifficulty();
        System.out.println("Game Difficulty: " + gameDifficulty);
        
        int boardSize = scanner.nextInt();
        return Game.builder()
                .withSize(boardSize)
                .withPlayer(humanPlayer)
                .withPlayer(
                        BotPlayer.builder()
                                .level(gameDifficulty)
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

    private static GameLevel getGameDifficulty() {
        Scanner scanner = new Scanner(System.in);
        int difficulty = scanner.nextInt();
        switch (difficulty) {
            case 1:
                return GameLevel.EASY;
            case 2:
                return GameLevel.MEDIUM;
            case 3:
                return GameLevel.HARD;
            default:
                return GameLevel.EASY;
        }
    }
}