package com.codingrodent.microprocessor.io.queue;

public class SimpleFastQueue {
    public Request request; // Points to the first element
    private Request tail; // Points to the last element

    public SimpleFastQueue() {
        this.request = null;
        this.tail = null;
    }

    // Adds a new request to the end of the queue
    public void add(Request request) {
        if (this.request == null) {
            this.request = request; // If the queue empty, head also points to the new request.
        } else {
            tail.next = request; // Link the current tail to the new request
        }
        tail = request; // Update the tail to the new request
    }

    // Removes request from the start of the queue.
    public void next() {
        request = request.next; // Move the head to the next element
    }

    // Clears the entire queue
    public void clear() {
        request = null;
    }

}
