package com.blazings.suanfa.designpattern.observer.caipiao;

import java.util.ArrayList;
import java.util.List;

public class ObjectFor3D implements SubjectI{

    List<ObserverI> observers = new ArrayList<ObserverI>();

    String msg;

    /**
     * @param observerI registerObserver
     */
    @Override
    public void registerObserver(ObserverI observerI) {
        observers.add(observerI);
    }

    @Override
    public void unregisterObserver(ObserverI observerI) {
        int indexOf = observers.indexOf(observerI);
        if (indexOf >= 0) {
            observers.remove(indexOf);
        }
    }

    @Override
    public void notifyObserver() {
        for (ObserverI observer : observers) {
            observer.update(msg);
        }
    }

    public void setMsg(String msg) {
        this.msg = msg;

        notifyObserver();
    }
}
