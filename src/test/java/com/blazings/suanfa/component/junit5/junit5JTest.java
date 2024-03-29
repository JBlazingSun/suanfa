package com.blazings.suanfa.component.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class junit5JTest {

	@Autowired
	Junit5J junit5J;

	@Mock
	Random random;
	@Test
	void PublicMethod() {
		Mockito.when(random.nextInt())
			.thenReturn(100)
				.thenReturn(200)
					.thenReturn(300);

		assertThat(100).isEqualTo(random.nextInt());
		assertThat(200).isEqualTo(random.nextInt());
		assertThat(300).isEqualTo(random.nextInt());

		Mockito.verify(random,Mockito.times(3)).nextInt();

//		InOrder inOrder = Mockito.inOrder(random);
//		inOrder.verify(random).nextInt();


	}

	@Test
	@DisplayName("add111111")
	void add() {
		Junit5J junit5J1 = new Junit5J();
		int add1 = junit5J1.add(1, 2);
		assertThat(3).isEqualTo(add1);

		int add = junit5J.add(1, 2);
		assertThat(add).isEqualTo(3);

	}

	//	@Test
	@DisplayName("add22222")
	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvSource({
		"1,2,3",
		"3,5,8",
		"1,1,2"
	})
	void add2(int one, int two, int result) {
		int add = junit5J.add(one, two);
		assertThat(result).isEqualTo(add);
	}

	@ParameterizedTest(name = "测试字符串回文")
	@ValueSource(strings = {
		"racec",
		"radar",
		"sddss",
		"daswd"
	})
	void palindromes(String strings) {
		assertThat(strings.length()).isEqualTo(5);
	}
}