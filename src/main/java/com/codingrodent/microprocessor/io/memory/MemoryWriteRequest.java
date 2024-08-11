package com.codingrodent.microprocessor.io.memory;

public class MemoryWriteRequest extends MemoryRequest {
    public final int payload;

    public MemoryWriteRequest(int address, int payload) {
        super(address);
        this.payload = payload;
    }
}
