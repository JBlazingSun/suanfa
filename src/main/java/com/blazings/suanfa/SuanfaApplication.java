package com.blazings.suanfa;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
@Slf4j
public class SuanfaApplication implements CommandLineRunner {

  //  @Resource
  //  MyPublisher myPublisher;

  @Resource RedissonClient client;

  public static void main(String[] args) {
    SpringApplication.run(SuanfaApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    log.info(client.getConfig().toYAML());
  }

}
