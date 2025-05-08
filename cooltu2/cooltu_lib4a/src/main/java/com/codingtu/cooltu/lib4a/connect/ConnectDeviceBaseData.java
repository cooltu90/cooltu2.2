package com.codingtu.cooltu.lib4a.connect;

import com.codingtu.cooltu.lib4j.data.data.LibDataObj;

public class ConnectDeviceBaseData extends LibDataObj {

    public int connectType;
    public int deviceType;
    public String name;
    public String mac;

    public ConnectDeviceBaseData() {
    }

    public ConnectDeviceBaseData(int connectType, int deviceType, String name, String mac) {
        this.connectType = connectType;
        this.deviceType = deviceType;
        this.name = name;
        this.mac = mac;
    }
}
