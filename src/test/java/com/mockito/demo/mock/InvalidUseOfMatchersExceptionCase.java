package com.mockito.demo.mock;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvalidUseOfMatchersExceptionCase {

	@Test
	public void second_stubbing_throws_InCorrectUseOfAPI() throws Exception {
		// Mock of Map interface
		Map<String, String> mapMock = mock(Map.class);
		Map<String, String> mapReal = new HashMap<String, String>();

		//Issue is here because performing argument matcher without mock object
		when(mapReal.get(anyString())).thenReturn("1st stubbing");

		//Correct statement
		//when(mapMock.get(anyString())).thenReturn("1st stubbing");

		Assertions.assertEquals(mapMock.get("Test"), "1st stubbing");

	}
}
