package com.blazings.suanfa.DesignPattern.Observer.caipiao;

public interface SubjectI {
    /**
     * @param observerI registerObserver
     */
    public void registerObserver(ObserverI observerI);

    public void unregisterObserver(ObserverI observerI);

    public void notifyObserver();

}
