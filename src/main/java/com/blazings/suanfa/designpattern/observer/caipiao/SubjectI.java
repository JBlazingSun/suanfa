package com.blazings.suanfa.designpattern.observer.caipiao;

public interface SubjectI {
    /**
     * @param observerI registerObserver
     */
    public void registerObserver(ObserverI observerI);

    public void unregisterObserver(ObserverI observerI);

    public void notifyObserver();

}
