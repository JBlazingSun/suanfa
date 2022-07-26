package com.blazings.suanfa.designpattern.observer.SpringObserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class OtherListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        log.info("OtherListener 听到了   "+ myEvent.msg);
    }
}
