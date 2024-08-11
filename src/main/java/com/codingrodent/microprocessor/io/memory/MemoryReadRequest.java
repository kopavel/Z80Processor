package com.codingrodent.microprocessor.io.memory;

import com.codingrodent.microprocessor.io.queue.Callback;
import com.codingrodent.microprocessor.io.queue.ReadRequest;

public class MemoryReadRequest extends ReadRequest implements MemoryRequest {
    public MemoryReadRequest(int address, Callback callback) {
        super(address, callback);
    }
}
