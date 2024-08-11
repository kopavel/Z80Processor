package com.codingrodent.microprocessor.io.queue;

public class RequestQueue {
    public Request head; // Points to the first element
    private Request tail; // Points to the last element

    public RequestQueue() {
        this.head = null;
        this.tail = null;
    }

    // Adds a new request to the end of the queue
    public void add(Request request) {
        if (head == null) {
            head = request; // If the queue was empty, head also points to the new request
        } else {
            tail.next = request; // Link the current tail to the new request
        }
        tail = request; // Update the tail to the new request
    }

    // Removes and returns the request at the start of the queue
    public Request poll() {
        if (head == null) {
            return null; // Queue is empty
        }
        Request request = head; // Get the current head
        head = head.next; // Move the head to the next element
        return request;
    }

    // Clears the entire queue
    public void clear() {
        head = null;
    }

}
