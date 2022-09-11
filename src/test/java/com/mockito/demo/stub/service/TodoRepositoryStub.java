package com.mockito.demo.stub.service;

import java.util.Arrays;
import java.util.List;

import com.mockito.demo.repository.TodoRepository;

public class TodoRepositoryStub implements TodoRepository {

	public List<String> retrieveTodos() {
		return Arrays.asList("Learn Spring", "learn Springboot", "learn mockito");
	}

	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring", "learn Springboot", "learn mockito");
	}

	@Override
	public void deleteTodo(String todo) {
	}

	@Override
	public void deleteTodo() {
	}

}
