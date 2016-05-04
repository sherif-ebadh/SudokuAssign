package com.sudoku;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sudoku.model.SudokuBoard;
import com.sudoku.utils.SudokuSolver;

/**
 * Created by Ninyo on 10/01/2016.
 */
public class SudokuSolverTest {

    @Test
    public void testValidCandidateAndPossibleSolution() {
        int[][] matrix = {{7, 0, 0, 0, 4, 0, 5, 3, 0},
                {0, 0, 5, 0, 0, 8, 0, 1, 0},
                {0, 0, 8, 5, 0, 9, 0, 4, 0},
                {5, 3, 9, 0, 6, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 5},
                {8, 0, 0, 7, 2, 0, 9, 0, 0},
                {9, 0, 7, 4, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 5, 7, 0, 0, 0},
                {6, 0, 0, 0, 0, 0, 0, 5, 0}};

        SudokuSolver solver = new SudokuSolver(new SudokuBoard(matrix));
        assertTrue(solver.checkCandidate(9, 0, 1));
        assertTrue(solver.checkPossibleSolution(9, 0, 1));
        assertFalse(solver.isSolved());

        assertTrue(solver.checkCandidate(4, 1, 0));
        assertTrue(solver.checkPossibleSolution(4, 1, 0));
        assertFalse(solver.isSolved());
    }

    @Test
    public void testValidCandidateAndNonePossibleSolution() {
        int[][] matrix = {{7, 0, 0, 0, 4, 0, 5, 3, 0},
                {0, 0, 5, 0, 0, 8, 0, 1, 0},
                {0, 0, 8, 5, 0, 9, 0, 4, 0},
                {5, 3, 9, 0, 6, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 5},
                {8, 0, 0, 7, 2, 0, 9, 0, 0},
                {9, 0, 7, 4, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 5, 7, 0, 0, 0},
                {6, 0, 0, 0, 0, 0, 0, 5, 0}};

        SudokuSolver solver = new SudokuSolver(new SudokuBoard(matrix));
        assertTrue(solver.checkCandidate(2, 0, 1));
        assertFalse(solver.checkPossibleSolution(2, 0, 1));
        assertFalse(solver.isSolved());
    }

    @Test
    public void testNoneValidCandidateAndNonePossibleSolution() {
        int[][] matrix = {{7, 0, 0, 0, 4, 0, 5, 3, 0},
                {0, 0, 5, 0, 0, 8, 0, 1, 0},
                {0, 0, 8, 5, 0, 9, 0, 4, 0},
                {5, 3, 9, 0, 6, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 5},
                {8, 0, 0, 7, 2, 0, 9, 0, 0},
                {9, 0, 7, 4, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 5, 7, 0, 0, 0},
                {6, 0, 0, 0, 0, 0, 0, 5, 0}};

        SudokuSolver solver = new SudokuSolver(new SudokuBoard(matrix));
        assertFalse(solver.checkCandidate(7, 0, 1));
        assertFalse(solver.checkPossibleSolution(7, 0, 1));
        assertFalse(solver.isSolved());
    }

    @Test
    public void testIsSolved() {
        int[][] matrix = {{7, 0, 2, 1, 4, 6, 5, 3, 8},
                {4, 6, 5, 2, 3, 8, 7, 1, 9},
                {3, 1, 8, 5, 7, 9, 6, 4, 2},
                {5, 3, 9, 8, 6, 4, 2, 7, 1},
                {2, 7, 6, 9, 1, 3, 4, 8, 5},
                {8, 4, 1, 7, 2, 5, 9, 6, 3},
                {9, 5, 7, 4, 8, 1, 3, 2, 6},
                {1, 2, 3, 6, 5, 7, 8, 9, 4},
                {6, 8, 4, 3, 9, 2, 1, 5, 7}};

        SudokuSolver solver = new SudokuSolver(new SudokuBoard(matrix));
        assertFalse(solver.isSolved());
        assertTrue(solver.checkCandidate(9, 0, 1));
        assertTrue(solver.checkPossibleSolution(9, 0, 1));
        assertTrue(solver.isSolved());
    }

}
