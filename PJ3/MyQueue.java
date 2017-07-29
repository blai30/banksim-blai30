/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PJ3;

import java.util.*;

/**
 * Taken from https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html
 * 
 * @author Brian
 */
public class MyQueue<T> implements QueueInterface {
    
    private T[] items;
    private int numItems;
    private int currentCap;
    private static int INITIAL_CAP = 25;
    
    public MyQueue() {
        this(INITIAL_CAP);
    }
    
    public MyQueue(int cap) {
        this.items = (T []) new Object[MyQueue.INITIAL_CAP];
        this.numItems = 0;
        this.currentCap = cap;
    }
    
    @Override
    public boolean add(Object newEntry) {
        if (this.numItems == this.currentCap) {
            this.expand();
        }
        this.items[this.numItems] = (T) newEntry;
        this.numItems++;
        return true;
    }

//    @Override
//    public boolean offer(Object newEntry) {
//        
//    }

    @Override
    public Object remove() {
        if (this.empty()) {
            throw new NoSuchElementException("Nothing to remove");
        }
        T data = this.items[0];
        this.items[0] = null;
        this.shiftQueue();
        this.numItems--;
        return data;
    }

    @Override
    public Object poll() {
        if (this.empty()) {
            return null;
        }
        T data = this.items[0];
        this.items[0] = null;
        this.shiftQueue();
        this.numItems--;
        return data;
    }

    @Override
    public Object element() {
        try {
            return this.items[0];
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Does not exist");
        }
    }

    @Override
    public Object peek() {
        return this.items[0];
    }

    @Override
    public boolean empty() {
        return this.numItems == 0;
    }

    @Override
    public int size() {
        return this.numItems;
    }

    @Override
    public void clear() {
        while (!this.empty()) {
            this.poll();
        }
    }

    @Override
    public void expand() {
        T[] expansion = (T[]) new Object[this.currentCap+25];
        System.arraycopy(this.items, 0, expansion, 0, this.numItems);
        this.items = expansion;
    }

    @Override
    public void shiftQueue() {
        if (this.size() > 1) {
            T t;
            for (int i = 0; i < numItems; i++) {
                t = this.items[i+1];
                this.items[i] = t;
            }
        }
    }
    
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(10);
        for (int i = 0; i < queue.currentCap; i++) {
            // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
            queue.add(i+1);
        }
        queue.poll();
        queue.poll();
        queue.poll();
        // [4, 5, 6, 7, 8, 9, 10, null, null, null]
        for (int i = 0; i < queue.currentCap; i++) {
            System.out.println(queue.items[i]);
        }
    }
}
