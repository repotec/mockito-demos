package com.mockito.demo.repository;

import java.util.List;

public interface TodoRepository {
	public List<String> retrieveTodos();
	public List<String> retrieveTodos(String dummy);
	
	public void deleteTodo(String dummy);
	public void deleteTodo();
}
