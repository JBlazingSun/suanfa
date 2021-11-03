package com.blazings.suanfa.DesignPattern.Adapter.Plug;

public interface DualPin {

    /**
     * //这里没有地线
     * @param l
     * @param n
     */
    void electrify(int l, int n);

}
