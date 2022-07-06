package com.blazings.suanfa.component.junit5;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
@Slf4j
class MockitoTest {
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	//6.验证顺序
	@Test
	void verifyOrder() {
		list.add("was added first");
		list.add("was added second");
		InOrder inOrder = inOrder(list);

		inOrder.verify(list).add("was added first");
		inOrder.verify(list).add("was added second");
		List list1 = mock(List.class);
		List list2 = mock(List.class);
		list1.add("was called first");
		list2.add("was called second");

		InOrder order = inOrder(list1, list2);
		order.verify(list1).add("was called first");
		order.verify(list2).add("was called second");
	}

	//5.存根带有异常的 void 方法
	@Test
	void Throwvoid() {
		doThrow(new RuntimeException()).when(linkedList).clear();
		try {
			linkedList.clear();
		} catch (Exception e) {
			log.info("doThrow");
		}
		/**
		 *  doThrow(new RuntimeException()).when(mockedList).clear();
		 *
		 *    //following throws RuntimeException:
		 *    mockedList.clear();
		 */
	}

	//4.验证准确的调用次数/ 至少 x次/从不
	@Test
	void VerifyTimes() {
		//using mock
		linkedList.add("once");

		linkedList.add("twice");
		linkedList.add("twice");

		linkedList.add("three times");
		linkedList.add("three times");
		linkedList.add("three times");
		verify(linkedList, times(1)).add("once");
		verify(linkedList, times(2)).add("twice");
		verify(linkedList, times(3)).add("three times");
		verify(linkedList, atLeast(1)).add("once");
		verify(linkedList, atLeast(2)).add("twice");
		verify(linkedList, atLeast(3)).add("three times");
		verify(linkedList, atMost(3)).add("three times");
		verify(linkedList, never()).add("never");
	}

	//3.参数匹配器
	//Mockito 以自然的 java 风格验证参数值：通过使用equals()方法。有时，当需要额外的灵活性时，您可以使用参数匹配器：
	@Test
	void ArgumentMatcher() {
		when(linkedList.get(anyInt())).thenReturn("element");
		log.info(String.valueOf(linkedList.get(999)));
	}

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
		log.info(String.valueOf(linkedList.get(999)));

		verify(linkedList,times(1)).get(0);
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