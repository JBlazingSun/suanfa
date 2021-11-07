package com.blazings.suanfa;

import com.blazings.suanfa.DesignPattern.Observer.SpringObserver.MyPublisher;
import com.blazings.suanfa.DesignPattern.Observer.caipiao.ObjectFor3D;
import com.blazings.suanfa.DesignPattern.Observer.caipiao.Observer1;
import com.blazings.suanfa.DesignPattern.Observer.caipiao.Observer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuanfaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SuanfaApplication.class, args);
    }

    @Autowired
    MyPublisher myPublisher;
    @Override
    public void run(String... args) throws Exception {

        
        System.out.println("SpringObserver");
        myPublisher.PublisherEvent("消息1111");
        myPublisher.PublisherEvent("消息22222");

        System.out.println("caipiao");
        ObjectFor3D objectFor3D = new ObjectFor3D();
        Observer1 observer1 = new Observer1(objectFor3D);
        Observer2 observer2 = new Observer2(objectFor3D);
//
        objectFor3D.setMsg("今天的号码是 17 22 42");
        objectFor3D.setMsg("明天的号码  12305 ");
    }
}
