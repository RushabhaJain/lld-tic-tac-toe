import exceptions.InvalidMoveException;
import models.Game;
import models.Move;
import models.Player;
import observers.Scoreboard;

public class TicTacToeSystem {
    private Game game;
    private static TicTacToeSystem instance;
    private final Scoreboard scoreboard;

    private TicTacToeSystem() {
        this.scoreboard = new Scoreboard();
    }

    public static synchronized TicTacToeSystem getInstance() {
        if (instance == null) {
            instance = new TicTacToeSystem();
        }
        return instance;
    }

    public void createGame(int size, Player player1, Player player2) {
        this.game = new Game(size, player1, player2);
        this.game.addObserver(scoreboard);
    }

    public void makeMove(Move move) throws InvalidMoveException {
        if (game == null) {
            System.out.println("No game in progress. Please create a game first.");
            return;
        }
        try {
            System.out.printf("%s plays at (%d, %d)%n", move.player().name(), move.row(), move.column());
            game.makeMove(move);
            printBoard();
            System.out.println("Game Status: " + game.getGameStatus());
            if (game.getWinner() != null) {
                System.out.println("Winner: " + game.getWinner().name());
            }
        } catch (InvalidMoveException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void printBoard() {
        game.getBoard().display();
    }

    public void printScoreboard() {
        System.out.println("########  Scoreboard  ########");
        scoreboard.display();
        System.out.println("##############################");
    }
}
