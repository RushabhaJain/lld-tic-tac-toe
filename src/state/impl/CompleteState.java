package state.impl;

import exceptions.InvalidMoveException;
import models.Game;
import models.Move;
import state.GameState;

public class CompleteState implements GameState {
    @Override
    public void handleMove(Game game, Move move) throws InvalidMoveException {
        throw new InvalidMoveException("Invalid move: game is already completed!");
    }
}
