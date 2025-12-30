package state.impl;

import enums.GameStatus;
import exceptions.InvalidMoveException;
import models.Game;
import models.Move;
import state.GameState;

public class InProgressState implements GameState {
    @Override
    public void handleMove(Game game, Move move) throws InvalidMoveException {
        if (move.player() != game.getCurrentPlayer()) {
            throw new InvalidMoveException("Not your turn!");
        }

        game.getBoard().makeMove(move);

        if (game.checkWinner()) {
            game.setWinner(move.player());
            game.setGameState(new CompleteState());
            game.setGameStatus(GameStatus.WIN);
        } else if (game.getBoard().isFull()) {
            game.setWinner(null);
            game.setGameStatus(GameStatus.DRAW);
            game.setGameState(new CompleteState());
        } else {
            game.switchPlayer();
        }
     }
}
