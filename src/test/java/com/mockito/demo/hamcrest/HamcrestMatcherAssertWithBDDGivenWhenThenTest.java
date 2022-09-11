package com.mockito.demo.hamcrest;

import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import com.mockito.demo.repository.TodoRepository;
import com.mockito.demo.service.TodoBusinessService;

public class HamcrestMatcherAssertWithBDDGivenWhenThenTest {

	@Test
	@DisplayName("BDD Given When-Then-Test with hamcrest-MatcherAssert")
	public void BDDGivenWhenThenTest() {
		//Given
		//given TodoRepository interface will return list of string
		TodoRepository todoServiceImplMock = mock(TodoRepository.class);
		BDDMockito.given(todoServiceImplMock.retrieveTodos()).willReturn((List<String>)Arrays.asList("Learn Spring", 
																						  			 "learn Springboot", 
																						  			 "learn mockito"));
		
		//[When] call retrieveTodosRelatedToSpring to filtration, will use the mock
		//pass mock object to service to be considered
		TodoBusinessService todoBusinessService = new TodoBusinessService(todoServiceImplMock);
		List<String> filteredList = todoBusinessService.retrieveTodosRelatedToSpring();
		
		//[Then] assert the size with what you got
		MatcherAssert.assertThat(filteredList.size(), CoreMatchers.is(2));
	}
}
