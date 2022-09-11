package com.mockito.demo.hamcrest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import java.util.Arrays;
import java.util.List;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HamcrestWithMickito {
	static List<Integer> list = null;
	@BeforeAll
	public static void beforeAll() {
		list = Arrays.asList(100, 200, 300, 400);
	}
	
	@Test
	public void arraySizeAssertThat_test() {
		MatcherAssert.assertThat(list, Matchers.hasSize(4));
	}
	
	@Test
	public void arrayItemsAssertThat_test() {		
		MatcherAssert.assertThat(list, Matchers.hasItems(100, 200));
	}
	
	@Test
	public void arrayEveyItemIsGreaterThanAssertThat_test() {	
		MatcherAssert.assertThat(list, Matchers.everyItem(Matchers.greaterThan(90)));
	}
	
	@Test
	public void arrayEveyItemIsLessThanAssertThat_test() {	
		MatcherAssert.assertThat(list, Matchers.everyItem(Matchers.lessThan(500)));
	}
	
//	@Test
//	public void StringEmptyAssertThat_test() {	
//		MatcherAssert.assertThat("", Matchers.isEmptyString());
//	}
	
	@Test
	public void StringIsEmptyAssertThat_test() {	
		MatcherAssert.assertThat("", is(Matchers.emptyString()));
	}
	
	@Test
	public void StringNullThanAssertThat_test() {	
		MatcherAssert.assertThat(null, is(Matchers.nullValue()));
	}
	
	@Test
	public void StringEmptyOrNullAssertThat_test() {	
		MatcherAssert.assertThat("", is(Matchers.emptyOrNullString()));
	}
	
	@Test
	public void StringNotEmptyOrNullAssertThat_test() {	
		String text = "test";
		MatcherAssert.assertThat(text, not(Matchers.emptyOrNullString()));
	}
}
