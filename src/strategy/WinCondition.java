package strategy;

import models.Board;

public interface WinCondition {
    boolean isSatisfied(Board board);
}
