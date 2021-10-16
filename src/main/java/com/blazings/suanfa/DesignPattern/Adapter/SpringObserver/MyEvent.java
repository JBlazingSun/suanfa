package com.blazings.suanfa.DesignPattern.Adapter.SpringObserver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Configuration;

public class MyEvent extends ApplicationEvent {

    public MyEvent(Object source) {
        super(source);
        System.out.println("MyEvent 构造器执行");
    }
    public void print(){
        System.out.println("hello spring event[MyEvent]");
    }
    public String biz(){
        return "biz";
    }
    public String DoSomething(){
        return "DoSomething";
    }
}
