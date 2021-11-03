package com.blazings.suanfa.DesignPattern.Observer.caipiao;

public class Observer1 implements ObserverI{
    SubjectI subjectI;

    public Observer1(SubjectI subjectI) {
        this.subjectI = subjectI;
        subjectI.registerObserver(this);
    }

    /**
     * @param msg message to send
     */
    @Override
    public void update(String msg) {

        System.out.println("Observer1的号码是  "+ msg);
    }
}
