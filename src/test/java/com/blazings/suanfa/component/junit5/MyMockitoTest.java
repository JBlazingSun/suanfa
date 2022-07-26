package com.blazings.suanfa.component.junit5;

import lombok.extern.slf4j.Slf4j;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@Slf4j
class MyMockitoTest {
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(MyMockitoTest.class);
	}
	//模拟静态方法（3.4.0 起）
	@Test
	void mockStatic() {
//		assertThat(3).isEqualTo(MyMockito.add(1, 2));
//		try(MockedStatic mocked = Mockito.mockStatic(MyMockito.class)){
//			mocked.when(MyMockito::add).thenReturn(5);
//			assertThat(3).isEqualTo(MyMockito.add(1, 2));
//		}
	}

	@Test
	void spyRealObject() {
		LinkedList<String> list1 = new LinkedList<>();
		LinkedList<String> spy = spy(list1);
//		when(spy.get(0)).thenReturn("ffff");

		doReturn("ffff").when(spy).get(0);
		log.info("{}", spy.get(0));

		assertThat(3).isEqualTo(MyMockito.add(1,2));
	}

	//11.使用回调存根,  允许使用通用Answer接口存根。
	@Test
	void CallBackAnswer() {
		when(list.get(618)).thenAnswer(
			new Answer() {
				public Object answer(InvocationOnMock invocation) {
					Object[] arguments = invocation.getArguments();
					Object mock = invocation.getMock();
					return "called with arguments:" + Arrays.toString(arguments) + " on mock " + mock;
				}
			}
		);
		log.info("{}", list.get(618));
	}

	//10.存根连续调用（迭代器式存根）
	@Test
	void AnyConsecutiveCall() {
		when(list.get(0))
			.thenThrow(new RuntimeException())
			.thenReturn("one","two", "three");
		try {
			Object o = list.get(0);
		} catch (Exception e) {
			log.info("catch thenThrow(new RuntimeException()");
		}
		assertThat(list.get(0)).isEqualTo("one");
		assertThat(list.get(0)).isEqualTo("two");
		assertThat(list.get(0)).isEqualTo("three");
		assertThat(list.get(0)).isEqualTo("three");
		assertThat(list.get(0)).isEqualTo("three");

		/**
		 *
		 when(mock.someMethod("some arg"))
		 .thenThrow(new RuntimeException())
		 .thenReturn("foo");

		 //First call: throws runtime exception:
		 mock.someMethod("some arg");

		 //Second call: prints "foo"
		 System.out.println(mock.someMethod("some arg"));

		 //Any consecutive call: prints "foo" as well (last stubbing wins).
		 System.out.println(mock.someMethod("some arg"));
		 */
	}

	//8.查找冗余调用
	@Test
	void FindNoMoreInteractions() {
		list.add("one");
//		list.add("two");
		verify(list).add("one");

		verifyNoMoreInteractions(list);
	}

	//7.确保交互从未在模拟中发生
	@Test
	void NerverHappen() {
		list.add("one");
		verify(list).add("one");
		verify(list, never()).add("two");
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

		verify(linkedList, times(1)).get(0);
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