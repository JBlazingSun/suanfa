package com.blazings.suanfa.designpattern.observer.SpringObserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
@Slf4j
public class OtherListener{

    @EventListener(MyEvent.class)
    public void OtherListenerEvent(MyEvent myEvent) throws InterruptedException {
        Thread.sleep(5 * 1000);
        log.info("OtherListener 听到了   " + myEvent.msg + "  " + Thread.currentThread().getName()
            + "  " + Thread.currentThread().getId()
            + "  " + System.currentTimeMillis());
    }
}
