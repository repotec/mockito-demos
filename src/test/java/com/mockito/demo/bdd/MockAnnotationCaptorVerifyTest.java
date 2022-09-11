package com.mockito.demo.bdd;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mockito.demo.repository.TodoRepository;
import com.mockito.demo.service.TodoBusinessService;
 
@ExtendWith(MockitoExtension.class)
public class MockAnnotationCaptorVerifyTest {
	@Mock
	TodoRepository todoRepoImplMock;
	
	//will create a new object of TodoBusinessService and inject it into TodoBusinessService
	@InjectMocks
	TodoBusinessService todoBusinessService;
	
	@Captor
	ArgumentCaptor<String> captor;
	
	@Test
	@DisplayName("behaviour development driven mock test1")
	public void bddMockCaptureArgs_thenShould_test() {
		BDDMockito.given(todoRepoImplMock.retrieveTodos("dummy")).willReturn((List<String>)Arrays.asList("Learn Spring", 
																									 	 "learn Springboot", 
																										 "learn mockito"));
		
		//when
		todoBusinessService.deleteTodosNotRelatedToSpring("dummy");

		//then with capture
		BDDMockito.then(todoRepoImplMock).should().deleteTodo(captor.capture());

		Mockito.verify(todoRepoImplMock).deleteTodo(captor.capture());
	}
}


