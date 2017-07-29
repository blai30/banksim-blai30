/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PJ3;

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
        if 
    }

    @Override
    public boolean offer(Object newEntry) {
        
    }

    @Override
    public Object remove(Object anEntry) {
        
    }

    @Override
    public Object poll(Object anEntry) {
        
    }

    @Override
    public Object element() {
        
    }

    @Override
    public Object peek() {
        
    }

    @Override
    public boolean empty() {
        
    }

    @Override
    public int size() {
        
    }

    @Override
    public void clear() {
        
    }
    
}
