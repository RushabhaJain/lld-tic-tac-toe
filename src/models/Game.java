package models;

import enums.GameStatus;
import exceptions.InvalidMoveException;
import observers.GameSubject;
import state.GameState;
import state.impl.InProgressState;
import strategy.WinCondition;
import strategy.impl.ColumnWinCondition;
import strategy.impl.CompositeWinCondition;
import strategy.impl.DiagonalWinCondition;
import strategy.impl.RowWinCondition;

import java.util.List;

public class Game extends GameSubject {
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Board board;
    private Player winner;
    private final WinCondition winCondition;
    private GameStatus gameStatus;
    private GameState gameState;

    public Game(int size, Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.board = new Board(size);
        winCondition = new CompositeWinCondition(
                List.of(
                        new RowWinCondition(),
                        new ColumnWinCondition(),
                        new DiagonalWinCondition()
                )
        );
        gameStatus = GameStatus.IN_PROGRESS;
        gameState = new InProgressState();
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
        if (gameStatus == GameStatus.WIN) {
            notifyObservers();
        }
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void makeMove(Move move) throws InvalidMoveException {
        gameState.handleMove(this, move);
    }

    public void switchPlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    /**
     * Check if the player is winner or not
     * @return boolean Whether player has won the game or not
     */
    public boolean checkWinner() {
        return winCondition.isSatisfied(board);
    }

    public void setWinner(Player player) {
        winner = player;
    }

    public Player getWinner() {
        return winner;
    }
}
