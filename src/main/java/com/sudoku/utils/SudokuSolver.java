package com.sudoku.utils;

import com.sudoku.model.SudokuBoard;


public class SudokuSolver {

    private SudokuBoard board;

    private SudokuBoard solvedBoard;

    public SudokuSolver(SudokuBoard board) {
        this.board = board;
        this.solvedBoard = new SudokuBoard(board);
        if (!solveBoard(0, 0)) {
            throw new RuntimeException("No possible solution!");
        }
    }

    public SudokuBoard getBoard() {
        return board;
    }

    public SudokuBoard getSolvedBoard() {
        return solvedBoard;
    }

    /**
     * Check if the board is solved.
     *
     * @return true if the board is solved or false otherwise.
     */
    public boolean isSolved() {
        for (int row = 0; row < board.getSize(); row++) {
            for (int col = 0; col < board.getSize(); col++) {
                if (board.getCell(row, col) != solvedBoard.getCell(row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Solve a Sudoku board
     *
     * @param row Cell's row.
     * @param col Cell's column.
     * @return false if no legal numbers are found for this cell.
     */
    public boolean solveBoard(int row, int col) {
        int nextCol = (col + 1) % solvedBoard.getSize();
        int nextRow = (nextCol == 0) ? row + 1 : row;

        try {
            if (solvedBoard.getCell(row, col) != solvedBoard.EMPTY_CELL)
                return solveBoard(nextRow, nextCol);
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }

        for (int i = 1; i <= solvedBoard.getSize(); i++) {
            if (checkCandidate(solvedBoard, i, row, col)) {
                solvedBoard.setCell(i, row, col);
                if (solveBoard(nextRow, nextCol)) {
                    return true;
                }
            }
        }
        solvedBoard.setCell(solvedBoard.EMPTY_CELL, row, col);
        return false;
    }

    /**
     * Check if a number for the given cell is a valid candidate.
     *
     * @param num.
     * @param row.
     * @param col.
     * @return false if num already appears in the row, column or box the cell belongs to or true otherwise.
     */
    public boolean checkCandidate(int num, int row, int col) {
        if (solvedBoard.getCell(row, col) == num) {
            return true;
        }
        return checkCandidate(board, num, row, col);
    }

    private boolean checkCandidate(SudokuBoard board, int num, int row, int col) {
        /*
        * board.getBlockSize() = 3 ->
        * row=[0, 2] -> blockTopLeftCornerRow = 0; row=[3, 5] -> blockTopLeftCornerRow = 3; row=[6, 8] -> blockTopLeftCornerRow = 6;
        * col=[0, 2] -> blockTopLeftCornerRowCol = 0; col=[3, 5] -> blockTopLeftCornerRowCol = 3; col=[6, 8] -> blockTopLeftCornerRowCol = 6;
        */
        int blockTopLeftCornerRow = (row / board.getBlockSize()) * board.getBlockSize();
        int blockTopLeftCornerRowCol = (col / board.getBlockSize()) * board.getBlockSize();
        /*
        * board.getBlockSize() = 3 ->
        * (i % board.getBlockSize()) = 0, 1, 2, 0, 1, 2, 0, 1, 2
        * (i / board.getBlockSize()) = 0, 0, 0, 1, 1, 1, 2, 2, 2
        */
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getCell(row, i) == num || board.getCell(i, col) == num ||
                    board.getCell(blockTopLeftCornerRow + (i % board.getBlockSize()), blockTopLeftCornerRowCol + (i / board.getBlockSize())) == num) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if a number for the given cell is part of a possible Sudoku solution.
     *
     * @param num.
     * @param row.
     * @param col.
     * @return true if num is part of a possible Sudoku solution or false otherwise.
     */
    public boolean checkPossibleSolution(int num, int row, int col) {
        if (solvedBoard.getCell(row, col) == num) {
            board.setCell(num, row, col);
            return true;
        }
        return false;
    }

}