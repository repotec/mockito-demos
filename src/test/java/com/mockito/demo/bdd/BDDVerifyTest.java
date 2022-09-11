package com.mockito.demo.bdd;

import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import com.mockito.demo.repository.TodoRepository;
import com.mockito.demo.service.TodoBusinessService;

public class BDDVerifyTest {
	@Test
	@DisplayName("behaviour development driven mock test1")
	public void bdd_mock_test1() {
		
		//Given
		//TodoRepository interface implementation as a mock object on fly will return List<String> to be ready for next steps
		TodoRepository todoRepoImpl = Mockito.mock(TodoRepository.class);
		BDDMockito.given(todoRepoImpl.retrieveTodos("dummy")).willReturn((List<String>)Arrays.asList("Learn Spring", 
																								     "learn Springboot", 
																								     "learn mockito"));
		
		//[When] pass mock object to service to be considered - constructor auto-wiring
		//pass mock object to service to be considered - constructor auto-wiring
		TodoBusinessService todoBusinessService = new TodoBusinessService(todoRepoImpl);
		todoBusinessService.deleteTodosNotRelatedToSpring("dummy");
		
		//[then] verify the same method is called
		//you have to sure about by which parameter deleteTodo has been called to be matched while verifying
		Mockito.verify(todoRepoImpl).deleteTodo("learn mockito");
	}
	
	@Test
	@DisplayName("behaviour development driven mock test1")
	public void bdd_mock_test2() {
		//[Given]TodoRepository interface implementation as a mock object on fly will return List<String> to be ready for next steps
		TodoRepository todoRepoImpl = mock(TodoRepository.class);
		BDDMockito.given(todoRepoImpl.retrieveTodos("dummy")).willReturn((List<String>)Arrays.asList("Learn Spring", 
																								     "learn Springboot", 
																								     "learn mockito"));
		
		//[When] pass mock object to service to be considered - constructor auto-wiring
		//pass mock object to service to be considered - constructor auto-wiring
		TodoBusinessService todoBusinessService = new TodoBusinessService(todoRepoImpl);
		todoBusinessService.deleteTodosNotRelatedToSpring("dummy");
		
		//[then] verify the same method is called
		//you have to sure about by which parameter deleteTodo has been called to be matched while verifying
		Mockito.verify(todoRepoImpl, Mockito.never()).deleteTodo("learn Springboot");
	}
	
	@Test
	@DisplayName("bdd verify mock test")
	public void bdd_mock_test3() {
		//[Given] TodoRepository interface implementation as a mock object on fly will return List<String> to be ready for next setps
		TodoRepository todoRepoImpl = mock(TodoRepository.class);
		BDDMockito.given(todoRepoImpl.retrieveTodos()).willReturn((List<String>)Arrays.asList("Learn Spring", 
																						      "learn Springboot", 
																						      "learn mockito"));
		
		//[when] call retrieveTodosRelatedToSpring to deleting, will use the mock
		//pass mock object to service to be considered - constructor auto-wiring
		TodoBusinessService todoBusinessService = new TodoBusinessService(todoRepoImpl);
		todoBusinessService.deleteTodosNotRelatedToSpring();
		
		//[then] verify the same method has been called
		//you have to sure about by which parameter deleteTodo has been called to be matched while verifying
		Mockito.verify(todoRepoImpl).deleteTodo();
	}
}
