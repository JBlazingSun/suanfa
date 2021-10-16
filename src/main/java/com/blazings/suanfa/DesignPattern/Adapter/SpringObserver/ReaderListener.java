package com.blazings.suanfa.DesignPattern.Adapter.SpringObserver;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReaderListener implements ApplicationListener<MyEvent>{
    String name;
    String article;

    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        UpdateArticle(myEvent);
    }

    private void UpdateArticle(MyEvent myEvent) {
        this.article = myEvent.DoSomething();
        System.out.printf("我是读者： %s，文章已更新为：  %s", this.name, this.article);
        System.out.println("");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}
