package implementação;

import java.util.NoSuchElementException;

public class Pilha{
    private int count;         
    private Node topo;     


    private class Node {
        private String element;
        private Node next;
    }

    public Pilha() {
        topo = null;
        count = 0;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public int size() {
        return count;
    }

    public void push(String element) {
        Node aux = topo;
        topo = new Node();
        topo.element = element;
        topo.next = aux;
        count++;
    }

    public String pop() {
        if (isEmpty()) 
            throw new NoSuchElementException("Pilha já vazia!");
        String element = topo.element;       
        topo = topo.next;            
        count--;
        return element;                   
    }

    public String top() {
        if (isEmpty()) 
            throw new NoSuchElementException("Pilha já vazia!");
        return topo.element;
    }
    
    public void clear(){
        while(isEmpty() == false){
            pop();
        }
    }
    
}
