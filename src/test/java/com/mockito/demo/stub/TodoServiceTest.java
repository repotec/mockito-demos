package com.mockito.demo.stub;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mockito.demo.service.TodoBusinessService;
import com.mockito.demo.stub.service.TodoRepositoryStub;

public class TodoServiceTest {
	
	@Test
	@DisplayName("todo service stube test")
	public void retrieveTodosRelated_TodoRepositoryImpl_test() {
		TodoRepositoryStub todoRepositoryStub = new TodoRepositoryStub();
		TodoBusinessService todoRepositoryImpl = new TodoBusinessService(todoRepositoryStub);
		List<String> todos = todoRepositoryImpl.retrieveTodosRelatedToSpring();
		assertEquals(2, todos.size());
	}
}
