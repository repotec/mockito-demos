package com.mockito.demo.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mockito.demo.repository.TodoRepository;

public class TodoServiceTest {
	
	@Test
	@DisplayName("todo service mock test")
	public void retrieveTodosRelated_TodoRepositoryImpl_mock_test() {
		TodoRepository todoRepositoryImplMock = mock(TodoRepository.class);
		List<String> todoList = Arrays.asList("Learn Spring", "learn Springboot", "learn mockito");
		when(todoRepositoryImplMock.retrieveTodos()).thenReturn(todoList);
		assertEquals(3, todoList.size());
	}
	
	
	@Test
	@DisplayName("todo service mock test")
	public void retrieveTodosRelated_TodoRepositoryImpl_mock2_test() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
	}
	
	@Test
	@DisplayName("todo service mock test")
	public void retrieveTodosRelated_TodoRepositoryImpl_mock3_test() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}
}