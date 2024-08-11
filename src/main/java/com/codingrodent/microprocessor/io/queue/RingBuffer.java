package com.codingrodent.microprocessor.io.queue;

public class RingBuffer<T> {
    public final int capacity;
    private final T[] buffer;
    public int size;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public RingBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = (T[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    // Add an element to the buffer
    public void add(T item) {
        if (size == capacity) {
            throw new IllegalStateException("Buffer is full");
        }
        buffer[tail] = item;
        tail = (tail + 1) % capacity;
        size++;
    }

    // Pull (remove and return) the head element from the buffer
    public T poll() {
        if (size == 0) {
            return null;
        } else {
            T item = buffer[head];
            buffer[head] = null;  // Optional: Help garbage collection
            head = (head + 1) % capacity;
            size--;
            return item;
        }
    }

    // Peek at the head element without removing it
    public T peek() {
        if (size == 0) {
            return null;
        } else {
            return buffer[head];
        }
    }

    // Check if the buffer is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Clear the buffer
    public void clear() {
        head = 0;
        tail = 0;
        size = 0;
    }

}
