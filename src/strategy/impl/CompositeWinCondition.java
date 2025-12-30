package strategy.impl;

import models.Board;
import strategy.WinCondition;

import java.util.List;

public class CompositeWinCondition implements WinCondition {

    private final List<WinCondition> winConditions;

    public CompositeWinCondition(List<WinCondition> winConditions) {
        this.winConditions = winConditions;
    }

    @Override
    public boolean isSatisfied(Board board) {
        for (WinCondition winCondition: winConditions) {
            if (winCondition.isSatisfied(board)) {
                return true;
            }
        }
        return false;
    }
}
