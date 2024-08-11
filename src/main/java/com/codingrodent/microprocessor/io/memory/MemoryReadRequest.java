package com.codingrodent.microprocessor.io.memory;

import com.codingrodent.microprocessor.io.queue.Callback;

public class MemoryReadRequest extends MemoryRequest {
    public final Callback callback;

    public MemoryReadRequest(int address, Callback callback) {
        super(address);
        this.callback = callback;
    }
}
