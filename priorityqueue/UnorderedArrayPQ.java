/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityqueue;

/**
 *
 * @author aawad
 */
public class UnorderedArrayPQ<key extends Comparable<key>> {
    private key[] pq;
    private int n;
    
    public UnorderedArrayPQ(int capacity){
        pq = (key[])new Comparable[capacity];
        n = 0;
    }
    
    public boolean isEmpty(){
        return n==0;
    }
    
    public int size(){
        return n;
    }
    
    public void insert(key x){
        pq[n] = x;
        n++;
    }
    
    public key delMax(){
        int max = 0;
        for(int i =1; i<n; i++)
        {
            if(!less(max, i)) max = i;           
        }
        exch(max, n-1);
        return pq[--n];
    }
    
    public boolean less(int i, int j){
        return pq[i].compareTo(pq[j])< 0;
    }
    
     public boolean greater(int i, int j){
        return pq[i].compareTo(pq[j])> 0;
    }
    
    public void exch(int i, int j){
        key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         UnorderedArrayPQ<String> pq = new UnorderedArrayPQ<String>(10);
        pq.insert("this");
        pq.insert("is");
        pq.insert("a");
        pq.insert("test");
        while (!pq.isEmpty()) 
            System.out.println(pq.delMax());
    }
    
}
