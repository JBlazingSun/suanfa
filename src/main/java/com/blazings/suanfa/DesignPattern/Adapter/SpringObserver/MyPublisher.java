package com.blazings.suanfa.DesignPattern.Adapter.SpringObserver;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyPublisher implements ApplicationContextAware {

    ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext= applicationContext;
    }

    public void PublisherEvent(){
        System.out.println("开始发布事件");
        applicationContext.publishEvent(new MyEvent(this,"aaa"));
    }
}
