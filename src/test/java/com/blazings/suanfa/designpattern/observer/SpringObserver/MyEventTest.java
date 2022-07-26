package com.blazings.suanfa.designpattern.observer.SpringObserver;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
class MyEventTest {
	@Resource
	MyPublisher myPublisher;

	@Test
	void doSomething() {
		myPublisher.publisherEvent("hello spring event");
	}
}