package strategy.impl;

import enums.Symbol;
import models.Board;
import strategy.WinCondition;

public class DiagonalWinCondition implements WinCondition {
    @Override
    public boolean isSatisfied(Board board) {
        // Check diagonal
        boolean diagonal = true;
        Symbol symbolToCheck = board.getCell(0, 0).getSymbol();
        if (symbolToCheck == Symbol.EMPTY) {
            diagonal = false;
        } else {
            for (int row = 0; row < board.getSize(); row++) {
                for (int column = 0; column < board.getSize(); column++) {
                    if (row == column) {
                        if (board.getCell(row, column).getSymbol() != symbolToCheck) {
                            diagonal = false;
                            break;
                        }
                    }
                }
            }
        }
        if (diagonal) {
            return true;
        }

        // Check cross-diagonal
        boolean crossDiagonal = true;
        symbolToCheck = board.getCell(board.getSize() - 1, 0).getSymbol();
        if (symbolToCheck == Symbol.EMPTY) {
            crossDiagonal = false;
        } else {
            for (int index = 0; index < board.getSize(); index++) {
                if (board.getCell(index, board.getSize() - 1 - index).getSymbol() != symbolToCheck) {
                    crossDiagonal = false;
                    break;
                }
            }
        }

        return crossDiagonal;
    }
}
