package com.sudoku.exception;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;

public interface ExceptionAttributes {

	Map<String, Object> getExceptionAttributes(Exception ex, HttpServletRequest request, HttpStatus httpStatus);
}
