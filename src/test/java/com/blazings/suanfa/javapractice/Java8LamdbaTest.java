package com.blazings.suanfa.javapractice;

import com.blazings.suanfa.javapractice.stream.Java8Lamdba;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Java8LamdbaTest {

  @Test()
  void showPredicate() {
    Java8Lamdba.ShowPredicate();
  }

  @Test
  void showPredicateFilter() {
    List<String> list3 = Arrays.asList("zhangSan", "liSi", "wangWu");
    System.out.println("转换之前的数据:" + list3);
    Predicate<String> stringPredicate =
        s -> {
          s += "后面加的";
          return s.contains("A") && s.contains("S");
        };
    List<String> stringList =
        list3.stream()
            .map(s -> s.toUpperCase())
            .filter(s -> stringPredicate.test(s))
            .collect(Collectors.toList());
    System.out.println(stringList);
  }

  @Test
  void StreamMapTest() {
    List<Integer> list5 = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 });
    List<Double> collect = list5.stream()
            .map(
                    integer -> {
                      return Math.pow(integer, 3);
                    })
            .collect(Collectors.toList());
    System.out.println(collect);
  }

  @BeforeEach
  void setUp() {}

  @AfterEach
  void tearDown() {}
}
