package com.blazings.suanfa.component.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;
@SpringBootTest
class AssertJJTest {

	//2.5.1。一个简单的例子
	@Test
	void simpleExample() {
		assertThat("The Lord of the Rings")
			.as("The result of the Lord of the Rings")
			.isNotNull()
			.startsWith("The")
			.contains("Lord")
			.endsWith("Rings");
	}
}