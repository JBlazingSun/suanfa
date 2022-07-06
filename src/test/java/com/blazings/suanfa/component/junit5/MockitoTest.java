package com.blazings.suanfa.component.junit5;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class MockitoTest {
	//2.一些存根怎么样？
	@Mock
	LinkedList linkedList;
	@Test
	void SomeStub() {
		when(linkedList.get(0)).thenReturn("first");
		when(linkedList.get(1)).thenThrow(new RuntimeException());
		log.info(linkedList.get(0).toString());
		try {
			log.info(linkedList.get(1).toString());
		} catch (Exception e) {
			log.info("exception");
		}
		// //following prints "null" because get(999) was not stubbed
		// System.out.println(mockedList.get(999));
		//
		// //Although it is possible to verify a stubbed invocation, usually it's just redundant
		// //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
		// //If your code doesn't care what get(0) returns, then it should not be stubbed.
		// verify(mockedList).get(0);
	}

	//1.让我们验证一些行为！
	//以下示例模拟了一个 List，因为大多数人都熟悉该接口（例如 add(), get(),clear()方法）。
	//实际上，请不要嘲笑 List 类。请改用真实实例。
	@Mock
	List list;
	@Test
	void VerifySomeAction() {
		list.add("one");
		list.clear();
		verify(list).add("one");
		verify(list).clear();
	}
}