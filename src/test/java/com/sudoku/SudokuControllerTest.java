package com.sudoku;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.CoreMatchers;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class SudokuControllerTest {

	final static String uri = "http://localhost:8080/sudoku/num/{num}/row/{row}/col/{col}";
	private static void addValidElemnet(){
	    HttpHeaders headers = new HttpHeaders();
	    headers.set("Accept", "application/json");
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("num", "1");
	    params.put("row", "0");
	    params.put("col", "3");
	    HttpEntity entity = new HttpEntity(headers);
	    RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> result = restTemplate .exchange(uri, HttpMethod.GET, entity, String.class,params);
	    System.out.println(result);
	    assertEquals("200" , result.getStatusCode().toString());
	    assertThat(result.getBody(), CoreMatchers.containsString("\"isValidCandidate\":true"));
	    assertThat(result.getBody(), CoreMatchers.containsString("\"isSolved\":false"));
	    assertThat(result.getBody(), CoreMatchers.containsString("\"isPossibleSolution\":true"));
	}
	
	private static void addInValidElemnet(){
	    HttpHeaders headers = new HttpHeaders();
	    headers.set("Accept", "application/json");
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("num", "6");
	    params.put("row", "0");
	    params.put("col", "3");

	    HttpEntity entity = new HttpEntity(headers);
	     
	    RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> result = restTemplate .exchange(uri, HttpMethod.GET, entity, String.class,params);
	    System.out.println(result);
	    assertEquals("200" , result.getStatusCode().toString());
	    assertThat(result.getBody(), CoreMatchers.containsString("\"isValidCandidate\":true"));
	    assertThat(result.getBody(), CoreMatchers.containsString("\"isSolved\":false"));
	    assertThat(result.getBody(), CoreMatchers.containsString("\"isPossibleSolution\":false"));

	}
	
//	// This test case will always fail unless we use a ready full matrix 
//	private static void testSolveFlag(){
//	    HttpHeaders headers = new HttpHeaders();
//	    headers.set("Accept", "application/json");
//	    Map<String, String> params = new HashMap<String, String>();
//	    params.put("num", "1");
//	    params.put("row", "0");
//	    params.put("col", "3");
//	    HttpEntity entity = new HttpEntity(headers);
//	    RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<String> result = restTemplate .exchange(uri, HttpMethod.GET, entity, String.class,params);
//	    System.out.println(result);
//	    assertEquals("200" , result.getStatusCode().toString());
//	    assertThat(result.getBody(), CoreMatchers.containsString("\"isValidCandidate\":true"));
//	    assertThat(result.getBody(), CoreMatchers.containsString("\"isSolved\":true"));
//	    assertThat(result.getBody(), CoreMatchers.containsString("\"isPossibleSolution\":true"));
//	}
	
	
	public static void main(String[] args)
	{

		addValidElemnet();
		addInValidElemnet();
	} 
}
