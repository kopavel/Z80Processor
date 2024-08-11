package com.codingrodent.microprocessor.io.queue;

@FunctionalInterface
public interface Callback {
    void accept(int data);
}
