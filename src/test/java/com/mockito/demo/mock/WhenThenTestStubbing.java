package com.mockito.demo.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.mockito.demo.repository.TodoRepository;
import com.mockito.demo.service.TodoBusinessService;

public class WhenThenTestStubbing {
	@Test
	@DisplayName("todo service mock test")
	public void retrieveTodosRelated_TodoRepositoryImpl_mock_test() {
		//Given
		//given TodoRepository interface will return list of string
		TodoRepository todoRepositoryMock = Mockito.mock(TodoRepository.class);
		Mockito.when(todoRepositoryMock.retrieveTodos()).thenReturn((List<String>)Arrays.asList("Learn Spring", 
																						  	     "learn Springboot", 
																							     "learn mockito"));
		//when call retrieveTodosRelatedToSpring to filtration, will use the mock
		//pass mock object to service to be consider
		TodoBusinessService todoBusinessService = new TodoBusinessService(todoRepositoryMock);
		List<String> filteredList = todoBusinessService.retrieveTodosRelatedToSpring();
		
		//Then
		//then assert the size with what you got
		assertEquals(2, filteredList.size());
	}
}
