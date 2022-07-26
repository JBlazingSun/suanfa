package com.blazings.suanfa.designpattern.observer.SpringObserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
@Slf4j
public class ReaderListener{
    String article;

    @EventListener(MyEvent.class)
    public void onApplicationEvent(MyEvent myEvent) {
        UpdateArticle(myEvent);
    }

    private void UpdateArticle(MyEvent myEvent) {
        this.article = myEvent.DoSomething();
        log.info("ReaderListener 听到了   "+ article);
    }
}
