package com.blazings.suanfa;

import com.blazings.suanfa.component.retrofit.HelloRetrofitClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class SuanfaApplication implements CommandLineRunner {

//  @Autowired
  final HelloRetrofitClient client;
  public static void main(String[] args) {
    SpringApplication.run(SuanfaApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    log.info(String.valueOf(Arrays.stream(args).count()));
    for (String arg : args) {
      log.info(arg);
    }
    client.getTime("mtop.common.getTimestamp");
  }

}
