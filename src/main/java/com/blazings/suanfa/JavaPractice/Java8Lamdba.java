package com.blazings.suanfa.JavaPractice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Java8Lamdba {
  public static void ShowPredicate() {
    List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
    System.out.println("Languages which starts with J :");
    ShowPredicateFilter(languages,l -> l.toString().startsWith("J"));

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
}
