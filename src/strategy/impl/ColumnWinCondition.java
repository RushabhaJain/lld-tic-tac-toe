package strategy.impl;

import enums.Symbol;
import models.Board;
import strategy.WinCondition;

public class ColumnWinCondition implements WinCondition {
    @Override
    public boolean isSatisfied(Board board) {
        for (int column = 0; column < board.getSize(); column++) {
            boolean result = true;
            Symbol symbolToCheck = board.getCell(0, column).getSymbol();
            for (int row = 0; row < board.getSize(); row++) {
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
