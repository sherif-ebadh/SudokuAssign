package com.sudoku.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudoku.model.BaseResponse;
import com.sudoku.model.SudokuBoard;
import com.sudoku.model.SudokuResponse;
import com.sudoku.utils.SudokuSolver;

@RestController
public class SudokuController {

	private static final Logger logger = LoggerFactory.getLogger(SudokuController.class);

	/**
	 * Initial Matrix.
	 */
	private int[][] matrix = { { 7, 0, 0, 0, 4, 0, 5, 3, 0 }, { 0, 0, 5, 0, 0, 8, 0, 1, 0 },
			{ 0, 0, 8, 5, 0, 9, 0, 4, 0 }, { 5, 3, 9, 0, 6, 0, 0, 0, 1 }, { 0, 0, 0, 0, 1, 0, 0, 0, 5 },
			{ 8, 0, 0, 7, 2, 0, 9, 0, 0 }, { 9, 0, 7, 4, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 5, 7, 0, 0, 0 },
			{ 6, 0, 0, 0, 0, 0, 0, 5, 0 } };

	// // For testing the Solved flag is fired when the Board completed
	// int[][] matrix = {{7,9,2,0,4,6,5,3,8},
	// {4,6,5,2,3,8,7,1,9},
	// {3,1,8,5,7,9,6,4,2},
	// {5,3,9,8,6,4,2,7,1},
	// {2,7,6,9,1,3,4,8,5},
	// {8,4,1,7,2,5,9,6,3},
	// {9,5,7,4,8,1,3,2,6},
	// {1,2,3,6,5,7,8,9,4},
	// {6,8,4,3,9,2,1,5,7}};

	@RequestMapping("/sudoku/num/{num}/row/{row}/col/{col}")
	public ResponseEntity<BaseResponse> sudoku(@PathVariable Integer num, @PathVariable Integer row,
			@PathVariable Integer col) {

		logger.info("Start SUDOKU controller");
		logger.debug("Path Variables num : " + num + " Row : " + row + " Col: " + col);

		// initiate the SUDOKU board and generate the solution based on the
		// given board
		SudokuSolver solver = new SudokuSolver(new SudokuBoard(matrix));
		if (num != null && row != null && col != null) {
			boolean isValidCandidate = solver.checkCandidate(num, row, col);
			boolean isPossibleSolution = solver.checkPossibleSolution(num, row, col);
			logger.info("isValidCandidate " + isValidCandidate);
			logger.info("isPossibleSolution " + isPossibleSolution);
			new SudokuResponse(solver.getBoard().getMatrix(), solver.isSolved(), isValidCandidate, isPossibleSolution);

			return new ResponseEntity<BaseResponse>(new SudokuResponse(solver.getBoard().getMatrix(), solver.isSolved(),
					isValidCandidate, isPossibleSolution), HttpStatus.OK);
		}

		return new ResponseEntity<BaseResponse>(new BaseResponse(solver.getBoard().getMatrix(), solver.isSolved()),
				HttpStatus.OK);
	}

}
