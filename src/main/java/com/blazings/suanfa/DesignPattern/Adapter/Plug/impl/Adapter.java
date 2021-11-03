package com.blazings.suanfa.DesignPattern.Adapter.Plug.impl;

import com.blazings.suanfa.DesignPattern.Adapter.Plug.DualPin;
import com.blazings.suanfa.DesignPattern.Adapter.Plug.TriplePin;

public class Adapter implements TriplePin {
    private DualPin dualPinDevice;

    /**
     * 创建适配器地时候，需要把双插设备接入进来
     * @param dualPinDevice
     */
    public Adapter(DualPin dualPinDevice) {
        this.dualPinDevice = dualPinDevice;
    }

    @Override
    public void electrify(int l, int n, int e) {
        //实际上调用了被适配设备的双插通电，地线e被丢弃了。
        dualPinDevice.electrify(l, n);
    }
}
