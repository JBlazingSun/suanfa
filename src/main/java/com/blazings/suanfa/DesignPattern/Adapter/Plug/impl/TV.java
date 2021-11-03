package com.blazings.suanfa.DesignPattern.Adapter.Plug.impl;

import com.blazings.suanfa.DesignPattern.Adapter.Plug.DualPin;

public class TV implements DualPin {
    @Override
    public void electrify(int l, int n) {
        System.out.println("火线通电：" + l);
        System.out.println("零线通电：" + n);
    }
}
