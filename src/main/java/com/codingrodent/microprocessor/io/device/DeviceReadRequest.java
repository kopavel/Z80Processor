package com.codingrodent.microprocessor.io.device;

import com.codingrodent.microprocessor.io.queue.Callback;
import com.codingrodent.microprocessor.io.queue.ReadRequest;

public class DeviceReadRequest extends ReadRequest implements DeviceRequest {
    public DeviceReadRequest(int address, Callback callback) {
        super(address, callback);
    }
}
