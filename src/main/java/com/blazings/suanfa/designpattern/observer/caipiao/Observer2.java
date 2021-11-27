package com.blazings.suanfa.designpattern.observer.caipiao;

public class Observer2 implements ObserverI{
    SubjectI subjectI;

    public Observer2(SubjectI subjectI) {
        this.subjectI = subjectI;
        subjectI.registerObserver(this);
    }

    /**
     * @param msg message to send
     */
    @Override
    public void update(String msg) {
        System.out.println("Observer2的号码是   "+msg);
    }
}
