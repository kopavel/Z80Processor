package com.codingrodent.microprocessor.io.queue;

public interface IoQueue {
    void writeWord(int address, int value);

    void writeByte(int address, int value);

    void readByte(int address, Callback callback);

    void readWord(int address, Callback callback);

    void ioRead(int address, Callback callback);

    void ioWrite(int address, int value);

    void clear();
}
