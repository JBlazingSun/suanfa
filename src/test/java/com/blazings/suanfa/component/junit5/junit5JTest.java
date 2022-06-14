package com.blazings.suanfa.component.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class junit5JTest {

	@Autowired
	Junit5J junit5J;
	@Test
	@DisplayName("add111111")
	void add() {
		int add = junit5J.add(1, 2);
		Assertions.assertEquals(3,add);
//		assertEquals(3,add);

	}
	@Test
	@DisplayName("add22222")
	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvSource({
		"1,2,3",
		"3,5,8",
		"1,1,2"
	})
	void add2(int one, int two, int result) {
		int add = junit5J.add(one, two);
		Assertions.assertEquals(result,add);
	}
}