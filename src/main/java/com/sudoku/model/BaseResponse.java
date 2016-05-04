package com.sudoku.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({"isSolved", "currentBoard"})
public class BaseResponse {

    protected int[][] currentBoard;
    protected boolean isSolved;

    public BaseResponse(int[][] currentBoard, boolean isSolved) {
        this.currentBoard = currentBoard;
        this.isSolved = isSolved;
    }

    @JsonProperty("currentBoard")
    public int[][] getBoard() {
        return currentBoard;
    }

    @JsonProperty("currentBoard")
    public void setBoard(int[][] currentBoard) {
        this.currentBoard = currentBoard;
    }

    @JsonProperty("isSolved")
    public boolean isSolved() {
        return isSolved;
    }

    @JsonProperty("isSolved")
    public void setSolved(boolean solved) {
        isSolved = solved;
    }

}

