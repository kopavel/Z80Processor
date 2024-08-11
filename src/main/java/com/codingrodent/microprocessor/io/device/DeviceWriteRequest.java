package com.codingrodent.microprocessor.io.device;

public class DeviceWriteRequest extends DeviceRequest {
    public final int payload;

    public DeviceWriteRequest(int address, int payload) {
        super(address);
        this.payload = payload;
    }
}
