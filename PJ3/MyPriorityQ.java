/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PJ3;

import java.util.NoSuchElementException;

/**
 * Taken from https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html
 *
 * @author Brian
 */
public class MyPriorityQ<T> implements QueueInterface {
    
    private T[] items;
    private int numItems;
    private int currentCap;
    private static int INITIAL_CAP = 25;
    
    public MyPriorityQ() {
        this(INITIAL_CAP);
    }
    
    public MyPriorityQ(int cap) {
        this.items = (T []) new Object[MyPriorityQ.INITIAL_CAP];
        this.numItems = 0;
        this.currentCap = cap;
    }

    @Override
    public boolean add(Object newEntry) {
        
    }

    @Override
    public Object remove() {
        
    }

    @Override
    public Object poll() {
        
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
        
    }

    @Override
    public void shiftQueue() {
        
    }
    
}
