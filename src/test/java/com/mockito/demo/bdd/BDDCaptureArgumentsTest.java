package com.mockito.demo.bdd;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import com.mockito.demo.repository.TodoRepository;
import com.mockito.demo.service.TodoBusinessService;

public class BDDCaptureArgumentsTest {
	@Test
	@DisplayName("behaviour development driven mock test1")
	public void bddMockCaptureArgs_thenShould_test() {
		TodoRepository todoRepoImpl = Mockito.mock(TodoRepository.class);
		List<String> todoList = Arrays.asList("Learn Spring", "learn Springboot", "learn mockito");
		BDDMockito.given(todoRepoImpl.retrieveTodos("dummy")).willReturn(todoList);

		TodoBusinessService todoBusinessService = new TodoBusinessService(todoRepoImpl);
		todoBusinessService.deleteTodosNotRelatedToSpring("dummy");
		
		//declare ArgumentCaptor
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class); 
		
		//define ArgumentCaptor for specific method call
		BDDMockito.then(todoRepoImpl).should().deleteTodo(captor.capture());
		
		//capture the argument
		MatcherAssert.assertThat(captor.getValue(), CoreMatchers.is(CoreMatchers.equalTo("learn mockito")));
	}
	
	
	@Test
	@DisplayName("behaviour development driven mock test1")
	public void bddMockCaptureArgs_verify_test() {
		TodoRepository todoRepoImpl = Mockito.mock(TodoRepository.class);
		List<String> todoList = Arrays.asList("Learn Spring", "learn Springboot", "learn mockito");
		BDDMockito.given(todoRepoImpl.retrieveTodos("dummy")).willReturn(todoList);

		TodoBusinessService todoBusinessService = new TodoBusinessService(todoRepoImpl);
		todoBusinessService.deleteTodosNotRelatedToSpring("dummy");
		
		Mockito.verify(todoRepoImpl).deleteTodo("learn mockito");
		
		//declare ArgumentCaptor
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class); 
		
		//define ArgumentCaptor for specific method call
		Mockito.verify(todoRepoImpl).deleteTodo(captor.capture());
		
		//capture the argument
		MatcherAssert.assertThat(captor.getValue(), CoreMatchers.is(CoreMatchers.equalTo("learn mockito")));
	}
	
	@Test
	@DisplayName("bddMockCaptureArgs_multiplTimes_thenShould_test")
	public void bddMockCaptureArgs_multiplTimes_thenShould_test() {
		TodoRepository todoRepoImpl = Mockito.mock(TodoRepository.class);
		List<String> todoList = Arrays.asList("Learn Spring", "learn junit", "learn mockito");
		BDDMockito.given(todoRepoImpl.retrieveTodos("dummy")).willReturn(todoList);

		TodoBusinessService todoBusinessService = new TodoBusinessService(todoRepoImpl);
		todoBusinessService.deleteTodosNotRelatedToSpring("dummy");
		
		//declare ArgumentCaptor
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class); 
		
		//define ArgumentCaptor for specific method call
		BDDMockito.then(todoRepoImpl).should(Mockito.atLeast(2)).deleteTodo(captor.capture());
		
		//capture the all arguments
		MatcherAssert.assertThat(captor.getAllValues().size(), CoreMatchers.is(2));
	}
}
