package com.codingrodent.microprocessor.io.device;

import com.codingrodent.microprocessor.io.queue.Request;

public class DeviceRequest extends Request {

    public DeviceRequest(int address) {
        super(address);
    }


}
