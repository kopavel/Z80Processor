package com.codingrodent.microprocessor.io.queue;

public class Request {
    public final int address;
    public Request next;
    public Request(int address) {
        this.address = address;
    }
}
