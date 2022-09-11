package com.mockito.demo.bdd;

import static org.mockito.Mockito.atLeast;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mockito.demo.repository.TodoRepository;
import com.mockito.demo.service.TodoBusinessService;
 
@ExtendWith(MockitoExtension.class)
public class MockAnnotationGivenThenTest {
	@Mock
	TodoRepository todoRepoImplMock;
	
	//will inject todoRepoImplMock inside TodoBusinessService
	@InjectMocks
	TodoBusinessService todoBusinessService;
	
	@Test
	@DisplayName("behaviour development driven mock test1")
	public void bddMockCaptureArgs_thenShould_test() {
		
		List<String> todoList = Arrays.asList("Learn Spring", "learn Springboot", "learn mockito");
		BDDMockito.given(todoRepoImplMock.retrieveTodos("dummy")).willReturn(todoList);

		todoBusinessService.deleteTodosNotRelatedToSpring("dummy");
		
		BDDMockito.then(todoRepoImplMock).should(atLeast(1)).deleteTodo("learn mockito");
	}
}
