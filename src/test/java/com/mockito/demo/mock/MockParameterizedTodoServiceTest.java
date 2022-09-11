package com.mockito.demo.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mockito.demo.repository.TodoRepository;
import com.mockito.demo.service.TodoBusinessService;

public class MockParameterizedTodoServiceTest {
	@Test
	@DisplayName("todo service mock test")
	public void retrieveTodosRelated_TodoRepositoryImpl_mock_test() {
		TodoRepository todoRepositoryImplMock = mock(TodoRepository.class);
		List<String> todoList = Arrays.asList("Learn Spring MVC", "learn Spring boot", "learn Mockito");
		when(todoRepositoryImplMock.retrieveTodos("dummy")).thenReturn(todoList);
		
		TodoBusinessService todoBusinessService = new TodoBusinessService(todoRepositoryImplMock);
		List<String> filteredList = todoBusinessService.retrieveTodosRelatedToSpring("dummy");
		assertEquals(2, filteredList.size());
	}
}
