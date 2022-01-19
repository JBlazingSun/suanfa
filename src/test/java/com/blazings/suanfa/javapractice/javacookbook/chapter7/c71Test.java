package com.blazings.suanfa.javapractice.javacookbook.chapter7;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

@SpringBootTest
@Slf4j
class c71Test {
  @Test
  void name71() {
    int[] monthLen1;
    monthLen1 = new int[12];
    int[] monthLen2 = new int[12];
    int[] monthLen3 = {31, 28, 31, 30};
    final int Max = 10;
    Calendar[] calendars = new Calendar[Max];
    for (int i = 0; i < calendars.length; i++) {
      calendars[i] = Calendar.getInstance();
    }

    int[][] me = new int[10][];
    for (int i = 0; i < me.length; i++) {
      me[i] = new int[24];
    }
    System.out.println(me.length);
    System.out.println(me[0].length);
  }
}
