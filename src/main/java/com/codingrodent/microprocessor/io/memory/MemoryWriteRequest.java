package com.codingrodent.microprocessor.io.memory;

import com.codingrodent.microprocessor.io.queue.WriteRequest;

public class MemoryWriteRequest extends WriteRequest implements MemoryRequest {
    public MemoryWriteRequest(int address, int payload) {
        super(address, payload);
    }
}
