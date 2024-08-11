package com.codingrodent.microprocessor.io.queue;

public class RingBuffer<T> {
    private final T[] buffer;
    private final int capacity;
    private int head;
    private int tail;
    private int size;

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
    public T pull() {
        if (isEmpty()) {
            throw new IllegalStateException("Buffer is empty");
        }
        T item = buffer[head];
        buffer[head] = null;  // Optional: Help garbage collection
        head = (head + 1) % capacity;
        size--;
        return item;
    }

    // Peek at the head element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Buffer is empty");
        }
        return buffer[head];
    }

    // Check if the buffer is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Clear the buffer
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            buffer[i] = null;
        }
        head = 0;
        tail = 0;
        size = 0;
    }

    // Get the current size of the buffer
    public int size() {
        return size;
    }

    // Get the capacity of the buffer
    public int capacity() {
        return capacity;
    }
}
