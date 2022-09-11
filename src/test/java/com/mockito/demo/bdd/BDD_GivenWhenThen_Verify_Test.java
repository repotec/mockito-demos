package com.mockito.demo.bdd;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import com.mockito.demo.repository.TodoRepository;
import com.mockito.demo.service.TodoBusinessService;

public class BDD_GivenWhenThen_Verify_Test {
	@Test
	@DisplayName("BDD Given-When-Then>AtLeast_Verify_Test")
	public void BDDGivenWhenThenVerify_AtLeast_Test() {
		
		//Given
		//TodoRepository interface implementation as a mock object on fly will return List<String> to be ready for next steps
		TodoRepository todoRepoImpl = mock(TodoRepository.class);
		BDDMockito.given(todoRepoImpl.retrieveTodos("dummy")).willReturn((List<String>)Arrays.asList("Learn Spring", 
																							  	     "learn Springboot", 
																								     "learn mockito"));
		
		//when call retrieveTodosRelatedToSpring to deleting, will use the mock
		//pass mock object to service to be considered - constructor auto-wiring
		TodoBusinessService todoBusinessService = new TodoBusinessService(todoRepoImpl);
		todoBusinessService.deleteTodosNotRelatedToSpring("dummy");

		//[verify] then verify the same method is never called
		Mockito.verify(todoRepoImpl, atLeast(1)).deleteTodo("learn mockito");
		
		//Then you have to sure about it, by with which parameter deleteTodo method is called to be matched while verifying
		BDDMockito.then(todoRepoImpl).should(atLeast(1)).deleteTodo("learn mockito");
	}
	
	@Test
	@DisplayName("BDD Given-When-Then>Never_Verify_Test")
	public void BDDGivenWhenThenVerify_Never_Test() {
		
		//Given
		//TodoRepository interface implementation as a mock object on fly will return List<String> to be ready for next setps
		TodoRepository todoRepoImpl = mock(TodoRepository.class);
		BDDMockito.given(todoRepoImpl.retrieveTodos("dummy")).willReturn((List<String>)Arrays.asList("Learn Spring", 
																							  	     "learn Springboot", 
																								     "learn mockito"));
		
		//When
		//pass mock object to service to be considered - constructor auto-wiring
		TodoBusinessService todoBusinessService = new TodoBusinessService(todoRepoImpl);
		
		//when call retrieveTodosRelatedToSpring to deleting, will use the mock
		todoBusinessService.deleteTodosNotRelatedToSpring("dummy");
		
		//[verify] the same method is never called
		Mockito.verify(todoRepoImpl, never()).deleteTodo("learn Springboot");
		
		//Then you have to sure about by which parameter deleteTodo has been called to be matched while verifying
		BDDMockito.then(todoRepoImpl).should(Mockito.never()).deleteTodo("learn Springboot");
	}
	
	@Test
	@DisplayName("BDD Given-When-Then>AtLeastOnce_Verify_Test")
	public void BDDGivenWhenThenVerify_AtLeastOnce_Test() {
		//[Given] TodoRepository interface implementation as a mock object on fly will return List<String> to be ready for next setps
		TodoRepository todoRepoImpl = mock(TodoRepository.class);
		BDDMockito.given(todoRepoImpl.retrieveTodos()).willReturn((List<String>)Arrays.asList("Learn Spring", 
																					  	     "learn Springboot", 
																						     "learn mockito"));
		
		//[when] call retrieveTodosRelatedToSpring to deleting, will use the mock
		//pass mock object to service to be considered - constructor auto-wiring
		TodoBusinessService todoBusinessService = new TodoBusinessService(todoRepoImpl);
		todoBusinessService.deleteTodosNotRelatedToSpring();
		
		//[Verify] verify the same method has been called
		Mockito.verify(todoRepoImpl, Mockito.atLeastOnce()).deleteTodo();
		
		//[then] you have to sure about by which parameter deleteTodo has been called to be matched while verifying
		BDDMockito.then(todoRepoImpl).should(Mockito.atLeastOnce()).deleteTodo();
	}
}
