package com.blazings.suanfa.javapractice.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8Lamdba {
  public static void ShowPredicate() {
    List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
    System.out.println("Languages which starts with J :");
    ShowPredicateFilter(languages, l -> l.toString().startsWith("J"));

    System.out.println("Languages which ends with a ");
    ShowPredicateFilter(languages, l -> l.toString().endsWith("a"));

    System.out.println("Print all languages :");
    ShowPredicateFilter(languages, l -> true);

    System.out.println("Print no language : ");
    ShowPredicateFilter(languages, l -> false);

    System.out.println("Print language whose length greater than 4:");
    ShowPredicateFilter(languages, l -> l.toString().length() > 4);
  }

  public static void ShowPredicateFilter(List<String> languages, Predicate predicate) {
    languages.stream()
        .filter(
            language -> {
              return predicate.test(language);
            })
        .forEach(
            s -> {
              System.out.println(s);
            });
  }

  public static void ListFilter(){
    List<String> list = Arrays.asList("张三", "李四", "王五", "xuwujing");
    System.out.println("过滤之前:" + list);
    List<String> result = new ArrayList<>();
    for (String str : list) {
      if (!"李四".equals(str)) {
        result.add(str);
      }
    }
//    System.out.println("过滤之后:" + result);

    List<String> collect = list.stream()
        .filter(s -> !s.equals("李四"))
            .collect(Collectors.toList());

    collect.add(("xuwujing"));
    System.out.println(collect);
  }
}
