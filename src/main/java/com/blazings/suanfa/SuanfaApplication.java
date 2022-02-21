package com.blazings.suanfa;

import cn.hutool.cron.CronUtil;
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
    CronUtil.setMatchSecond(true);
    CronUtil.start();

    //    Config config = Config.fromYAML(new File("src/main/resources/redisson.yml"));
    //    RedissonClient client = Redisson.create(config);
    //    RAtomicDouble atomicDouble = client.getAtomicDouble("myDouble");
    //    atomicDouble.getAndIncrement();
    //    atomicDouble.expire(10, TimeUnit.MINUTES);
    log.info(client.getConfig().toYAML());
  }

}
