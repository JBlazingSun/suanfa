package com.blazings.suanfa;

import com.blazings.suanfa.designpattern.observer.SpringObserver.MyPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuanfaApplication implements CommandLineRunner {

  @Autowired
  MyPublisher myPublisher;

  public static void main(String[] args) {
    SpringApplication.run(SuanfaApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

  }
}
