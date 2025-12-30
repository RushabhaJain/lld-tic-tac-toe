package state;

import exceptions.InvalidMoveException;
import models.Game;
import models.Move;

public interface GameState {
    void handleMove(Game game, Move move) throws InvalidMoveException;
}
