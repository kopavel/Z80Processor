package com.codingrodent.microprocessor.io.queue;

import com.codingrodent.microprocessor.io.device.DeviceReadRequest;
import com.codingrodent.microprocessor.io.device.DeviceWriteRequest;
import com.codingrodent.microprocessor.io.memory.MemoryReadRequest;
import com.codingrodent.microprocessor.io.memory.MemoryWriteRequest;

public class AsyncIoQueue implements IoQueue {
    public final RingBuffer<Request> requests = new RingBuffer<>(10);

    @Override
    public void writeWord(int address, int value) {
        requests.add(new MemoryWriteRequest(address, value & 0xff));
        requests.add(new MemoryWriteRequest(address + 1, value >> 8));
    }

    @Override
    public void writeByte(int address, int value) {
        requests.add(new MemoryWriteRequest(address, value));
    }

    @Override
    public void readByte(int address, Callback callback) {
        requests.add(new MemoryReadRequest(address, callback));
    }

    @Override
    public void readWord(int address, Callback callback) {
        readByte(address, (lowByte) -> readByte(address + 1, (hiByte) -> callback.accept((hiByte << 8) + lowByte)));
    }

    @Override
    public void ioRead(int address, Callback callback) {
        requests.add(new DeviceReadRequest(address, callback));
    }

    @Override
    public void ioWrite(int address, int value) {
        requests.add(new DeviceWriteRequest(address, value));
    }

    @Override
    public void clear() {
        requests.clear();
    }
}
