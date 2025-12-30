package models;

import enums.Symbol;
import exceptions.InvalidMoveException;

/**
 * Manages the board, updating the board by making a move
 */
public class Board {
    private final Cell[][] grid;
    private int moveCount;
    private int size;

    public Board(int size) {
        grid = new Cell[size][size];
        this.size = size;
        moveCount = 0;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                grid[row][col] = new Cell();
            }
        }
    }

    public Cell getCell(int row, int column) {
        return grid[row][column];
    }

    public void makeMove(Move move) throws InvalidMoveException {
        int row = move.row();
        int column = move.column();

        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length) {
            throw new InvalidMoveException("Invalid position: You cannot make a move to a position which outside of the grid");
        }

        Cell cell = grid[row][column];

        if (cell.getSymbol() != Symbol.EMPTY) {
            throw new InvalidMoveException("Invalid selection: You cannot make a move on a non-empty place");
        }

        cell.setSymbol(move.player().symbol());

        moveCount += 1;
    }

    public boolean isFull() {
        return moveCount == grid.length * grid.length;
    }

    public void display() {
        for (Cell[] cells : grid) {
            System.out.println("--------------------");
            for (int column = 0; column < grid[0].length; column += 1) {
                System.out.printf("|--%s--|", cells[column].getSymbol().getValue());
            }
            System.out.printf("%n");
        }
        System.out.println("--------------------");
    }

    public int getSize() {
        return size;
    }
}
