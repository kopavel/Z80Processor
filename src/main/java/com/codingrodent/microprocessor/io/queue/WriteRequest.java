package com.codingrodent.microprocessor.io.queue;

public class WriteRequest extends Request {
    public final int payload;

    public WriteRequest(int address, int payload) {
        super(address);
        this.payload = payload;
    }
}
