package com.blazings.suanfa.component.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class junit5JTest {

	@Autowired
	Junit5J junit5J;
	@Test
	void add() {
		int add = junit5J.add(1, 2);

	}
	@Test
	void add2() {
		int add = junit5J.add(3, 3);

	}
}