package com.codingrodent.microprocessor.io.queue;

public class ReadRequest extends Request {
    public final Callback callback;

    public ReadRequest(int address, Callback callback) {
        super(address);
        this.callback = callback;
    }
}
