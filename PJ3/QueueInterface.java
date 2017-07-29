/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PJ3;

/**
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
}
