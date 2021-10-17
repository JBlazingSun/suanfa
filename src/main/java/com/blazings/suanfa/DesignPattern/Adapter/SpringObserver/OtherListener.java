package com.blazings.suanfa.DesignPattern.Adapter.SpringObserver;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtherListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
    System.out.println("OtherListener 听到了   "+ myEvent.msg);
    }
}
