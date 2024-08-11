package com.codingrodent.microprocessor.io.device;


import com.codingrodent.microprocessor.io.queue.WriteRequest;

public class DeviceWriteRequest extends WriteRequest implements DeviceRequest {
    public DeviceWriteRequest(int address, int payload) {
        super(address, payload);
    }
}
