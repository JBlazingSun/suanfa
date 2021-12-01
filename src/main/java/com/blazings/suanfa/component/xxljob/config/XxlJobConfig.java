package com.blazings.suanfa.component.xxljob.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XxlJobConfig {
  @Value("${xxl.job.admin.addresses}")
  String adminAddresses;

  @Value("${xxl.job.accessToken}")
  String accessToken;
  //
  @Value("${xxl.job.executor.appname}")
  String appname;
  //
  //  @Value("${xxl.job.executor.ip}")
  //  String ip;
  //
  //  @Value("${xxl.job.executor.port}")
  //  int port;
  //
  //  @Value("${xxl.job.executor.logpath}")
  //  String logPath;
  //
  //  @Value("${xxl.job.executor.logretentiondays}")
  //  int logRetentionDays;

  @Bean
  public XxlJobSpringExecutor xxlJobExecutor() {
    XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
    xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
    xxlJobSpringExecutor.setAppname(appname);
    //    xxlJobSpringExecutor.setIp(ip);
    //    xxlJobSpringExecutor.setPort(port);
    xxlJobSpringExecutor.setAccessToken(accessToken);
    //    xxlJobSpringExecutor.setLogPath(logPath);
    //    xxlJobSpringExecutor.setLogRetentionDays(logRetentionDays);
    return xxlJobSpringExecutor;
  }
}
