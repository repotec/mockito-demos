package com.mockito.demo.bdd;

import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import com.mockito.demo.repository.TodoRepository;
import com.mockito.demo.service.TodoBusinessService;

public class GivenWhenThenTest {

	@Test
	@DisplayName("BDD given-when-then mock test")
	public void givenWhenThenMock_test() {
		//[Given] TodoRepository interface will return list of string
		TodoRepository todoServiceImplMock = mock(TodoRepository.class);
		BDDMockito.given(todoServiceImplMock.retrieveTodos()).willReturn((List<String>)Arrays.asList("Learn Spring", 
																							  	     "learn Springboot", 
																								     "learn mockito"));

		//[When] call retrieveTodosRelatedToSpring to filtration, will use the mock
		//pass mock object to service to be consider
		TodoBusinessService todoBusinessService = new TodoBusinessService(todoServiceImplMock);
		List<String> filteredList = todoBusinessService.retrieveTodosRelatedToSpring();
		
		//[Then] assert the size with what we get
		Assertions.assertEquals(filteredList.size(), 2);
	}
	
}