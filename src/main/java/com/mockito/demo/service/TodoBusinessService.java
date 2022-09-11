package com.mockito.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.mockito.demo.repository.TodoRepository;

public class TodoBusinessService {
	private TodoRepository todoRepository;

	public TodoBusinessService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	public List<String> retrieveTodosRelatedToSpring(String dummy) {
		List<String> filteredTodos = new ArrayList<String>();
		List<String> allTodos = todoRepository.retrieveTodos(dummy);
		for (String todo : allTodos) {
			if (todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}

	public List<String> retrieveTodosRelatedToSpring() {
		List<String> filteredTodos = new ArrayList<String>();
		List<String> allTodos = todoRepository.retrieveTodos();
		for (String todo : allTodos) {
			if (todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
	public void deleteTodosNotRelatedToSpring(String dummy) {
		List<String> allTodos = todoRepository.retrieveTodos(dummy);
		for (String todo : allTodos) {
			if (!todo.contains("Spring")) {
				todoRepository.deleteTodo(todo);
			}
		}
	}
	
	public void deleteTodosNotRelatedToSpring() {
		List<String> allTodos = todoRepository.retrieveTodos();
		for (String todo : allTodos) {
			if (!todo.contains("Spring")) {
				todoRepository.deleteTodo();
			}
		}
	}
}
