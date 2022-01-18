package com.blazings.suanfa;

import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import com.blazings.suanfa.designpattern.observer.SpringObserver.MyPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
@Slf4j
public class SuanfaApplication implements CommandLineRunner {

  @Resource
  MyPublisher myPublisher;

  public static void main(String[] args) {
    SpringApplication.run(SuanfaApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    CronUtil.setMatchSecond(true);
    CronUtil.start();
  }
}
