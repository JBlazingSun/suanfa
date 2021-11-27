package com.blazings.suanfa.designpattern.observer.SpringObserver;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReaderListener implements ApplicationListener<MyEvent>{
    String article;

    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        UpdateArticle(myEvent);
    }

    private void UpdateArticle(MyEvent myEvent) {
        this.article = myEvent.DoSomething();
    }
}
