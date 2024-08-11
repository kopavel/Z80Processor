package com.codingrodent.microprocessor.io.memory;

import com.codingrodent.microprocessor.io.queue.Request;

public class MemoryRequest extends Request {
    public MemoryRequest(int address) {
        super(address);
    }
}
