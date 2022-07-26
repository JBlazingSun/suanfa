package com.blazings.suanfa.component.junit5;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MyMockito {
	public static int add(int i, int junit5J) {
		return i+junit5J;
	}

	public static void add() {
	}
}
