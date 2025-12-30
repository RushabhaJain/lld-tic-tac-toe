import enums.Symbol;
import exceptions.InvalidMoveException;
import models.Move;
import models.Player;

public class Main {
    public static void main(String[] args) throws InvalidMoveException {
        TicTacToeSystem system = TicTacToeSystem.getInstance();

        Player alice = new Player(1, "Alice", Symbol.X);
        Player bob = new Player(2, "Bob", Symbol.O);

        // --- GAME 1: Alice wins ---
        System.out.println("--- GAME 1: Alice (X) vs. Bob (O) ---");
        system.createGame(3, alice, bob);
        system.printBoard();

        system.makeMove(new Move(alice, 0, 0));
        system.makeMove(new Move(bob, 1, 0));
        system.makeMove(new Move(alice, 0, 1));
        system.makeMove(new Move(bob, 1, 1));
        system.makeMove(new Move(alice, 0, 2)); // Alice wins, scoreboard is notified
        system.printScoreboard();
        System.out.println("----------------------------------------\n");

        // --- GAME 2: Bob wins ---
        System.out.println("--- GAME 2: Alice (X) vs. Bob (O) ---");
        system.createGame(3, alice, bob); // A new game instance
        system.printBoard();

        system.makeMove(new Move(alice, 0, 0));
        system.makeMove(new Move(bob, 1, 0));
        system.makeMove(new Move(alice, 0, 1));
        system.makeMove(new Move(bob, 1, 1));
        system.makeMove(new Move(alice, 2, 2));
        system.makeMove(new Move(bob, 1, 2)); // Bob wins, scoreboard is notified
        system.printScoreboard();
        System.out.println("----------------------------------------\n");

        // --- GAME 3: A Draw ---
        System.out.println("--- GAME 3: Alice (X) vs. Bob (O) - Draw ---");
        system.createGame(3, alice, bob);
        system.printBoard();

        system.makeMove(new Move(alice, 0, 0));
        system.makeMove(new Move(bob, 0, 1));
        system.makeMove(new Move(alice, 0, 2));
        system.makeMove(new Move(bob, 1, 1));
        system.makeMove(new Move(alice, 1, 0));
        system.makeMove(new Move(bob, 1, 2));
        system.makeMove(new Move(alice, 2, 1));
        system.makeMove(new Move(bob, 2, 0));
        system.makeMove(new Move(alice, 2, 2)); // Draw, scoreboard is not notified of a winner
        System.out.println("----------------------------------------\n");

//        // --- Final Scoreboard ---
//        // We get the scoreboard from the system and print its final state
//        system.printBoard();
    }
}
