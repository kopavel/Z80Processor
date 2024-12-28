package com.codingrodent.microprocessor.io.queue;

public class Request {
    public int address = -1;
    public boolean read;
    public long payload;
    public Callback callback;
    public Request next;
    public boolean memory;
}
