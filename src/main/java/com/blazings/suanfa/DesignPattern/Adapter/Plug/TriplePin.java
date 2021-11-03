package com.blazings.suanfa.DesignPattern.Adapter.Plug;

public interface TriplePin {
    /**
     * 参数分别为火线live，零线null，地线earth
     * @param l
     * @param n
     * @param e
     */
    void electrify(int l, int n, int e);
}
