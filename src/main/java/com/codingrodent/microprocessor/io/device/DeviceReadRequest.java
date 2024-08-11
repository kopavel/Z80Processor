package com.codingrodent.microprocessor.io.device;

import com.codingrodent.microprocessor.io.queue.Callback;

public class DeviceReadRequest extends DeviceRequest {
    public final Callback callback;

    public DeviceReadRequest(int address, Callback callback) {
        super(address);
        this.callback = callback;
    }
}
