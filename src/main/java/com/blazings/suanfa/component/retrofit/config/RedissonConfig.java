//package com.blazings.suanfa.config;
//
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.File;
//import java.io.IOException;
//
////@Configuration
//public class RedissonConfig {
////  @Bean
//  public RedissonClient redisson() throws IOException {
//    // 本例子使用的是yaml格式的配置文件，读取使用Config.fromYAML，如果是Json文件，则使用Config.fromJSON
//    Config config = Config.fromYAML(new File("src/main/resources/redisson.yml"));
//    return Redisson.create(config);
//  }
//}
