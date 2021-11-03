package com.blazings.suanfa.DesignPattern.Observer.SpringObserver;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {
    String msg;

    public MyEvent(Object source,String msg) {
        super(source);
        this.msg = msg;
        System.out.println("MyEvent 构造器执行");
    }
    public void print(){
        System.out.println("hello spring event[MyEvent]");
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
