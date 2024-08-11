package com.codingrodent.microprocessor.io.queue;

import com.codingrodent.microprocessor.IBaseDevice;
import com.codingrodent.microprocessor.IMemory;

public class SyncIoQueue implements IoQueue {
    private final IMemory memory;
    private final IBaseDevice ioDevice;

    public SyncIoQueue(IMemory memory, IBaseDevice ioDevice) {
        this.memory = memory;
        this.ioDevice = ioDevice;
    }

    @Override
    public void writeWord(int address, int value) {
        memory.writeWord(address, value);
    }

    @Override
    public void writeByte(int address, int value) {
        memory.writeByte(address, value);
    }

    @Override
    public void readByte(int address, Callback callback) {
        callback.accept(memory.readByte(address));
    }

    @Override
    public void readWord(int address, Callback callback) {
        callback.accept(memory.readWord(address));
    }

    @Override
    public void ioRead(int address, Callback callback) {
        callback.accept(ioDevice.IORead(address));
    }

    @Override
    public void ioWrite(int address, int value) {
        ioDevice.IOWrite(address, value);
    }

    @Override
    public void clear() {

    }

}
