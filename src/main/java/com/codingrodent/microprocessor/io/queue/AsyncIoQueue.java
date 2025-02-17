package com.codingrodent.microprocessor.io.queue;
public class AsyncIoQueue implements IoQueue {
    public Request request;
    public Request write;
    int previousAddress;
    int lowByte;
    Callback wordCallback;
    private final Callback hiWordReadCallback = (hiByte) -> wordCallback.accept((hiByte << 8) + lowByte);
    private final Callback loReadWordCallback = lowByte -> {
        shiftWrite();
        this.lowByte = lowByte;
        write.address = previousAddress + 1;
        write.read = true;
        write.memory = true;
        write.callback = hiWordReadCallback;
    };

    public AsyncIoQueue() {
        write = new Request();
        request = write;
        write.next = write;
    }

    @Override
    public void writeWord(int address, int value) {
        shiftWrite();
        write.address = address;
        write.read = false;
        write.memory = true;
        write.payload = value & 0xff;
        shiftWrite();
        write.address = address + 1;
        write.read = false;
        write.memory = true;
        write.payload = value >> 8;
    }

    @Override
    public void writeByte(int address, int value) {
        shiftWrite();
        write.address = address;
        write.read = false;
        write.memory = true;
        write.payload = value;
    }

    @Override
    public void readByte(int address, Callback callback) {
        shiftWrite();
        write.address = address;
        write.read = true;
        write.memory = true;
        write.callback = callback;
    }

    @Override
    public void readWord(int address, Callback callback) {
        shiftWrite();
        previousAddress = address;
        wordCallback = callback;
        write.address = address;
        write.read = true;
        write.memory = true;
        write.callback = loReadWordCallback;
    }

    @Override
    public void ioRead(int address, Callback callback) {
        shiftWrite();
        write.address = address;
        write.read = true;
        write.memory = false;
        write.callback = callback;
    }

    @Override
    public void ioWrite(int address, int value) {
        shiftWrite();
        write.address = address;
        write.read = false;
        write.memory = false;
        write.payload = value;
    }

    @Override
    public void clear() {
        request = write;
        write.address = -1;
        write.next=write;
    }

    public void next() {
        request.address = -1;
        request = request.next;
    }

    private void shiftWrite() {
        if (write.next.address != -1) {
            Request next = write.next;
            Request newRequest = new Request();
            newRequest.next = next;
            write.next = newRequest;
            write = newRequest;
        } else {
            write = write.next;
        }
    }
}
