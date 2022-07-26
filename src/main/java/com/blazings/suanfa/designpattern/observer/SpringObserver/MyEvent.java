package com.blazings.suanfa.designpattern.observer.SpringObserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

@Slf4j
public class MyEvent extends ApplicationEvent {
    String msg;

    public MyEvent(Object source,String msg) {
        super(source);
        this.msg = msg;
        log.info("MyEvent 构造器执行");
    }

    public void print(){
        log.info("hello spring event[MyEvent]");
    }
    public String DoSomething(){
        return "DoSomething   "+msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
