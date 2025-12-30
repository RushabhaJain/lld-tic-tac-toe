package strategy.impl;

import enums.Symbol;
import models.Board;
import strategy.WinCondition;

public class RowWinCondition implements WinCondition {
    @Override
    public boolean isSatisfied(Board board) {
        for (int row = 0; row < board.getSize(); row++) {
            boolean result = true;
            Symbol symbolToCheck = board.getCell(row, 0).getSymbol();
            for (int column = 0; column < board.getSize(); column++) {
                Symbol currentSymbol = board.getCell(row, column).getSymbol();
                if (currentSymbol == Symbol.EMPTY || symbolToCheck != currentSymbol) {
                    result = false;
                    break;
                }
            }
            if (result) {
                return true;
            }
        }
        return false;
    }
}
