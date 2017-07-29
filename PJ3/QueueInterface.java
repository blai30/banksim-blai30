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
public interface QueueInterface<T> {
    
    public boolean add(T newEntry);
    
    public boolean offer(T newEntry);
    
    public T remove(T anEntry);
    
    public T poll(T anEntry);
    
    public T element();
    
    public T peek();
    
    public boolean empty();
    
    public int size();
    
    public void clear();
    
}
