package controller.tda.list;
// T DATO GENERICO NORMAL
// K,V PARA DICCIONARIOS

import java.io.Serializable;


public class Node <E> implements Serializable{
    private E info;
    Node <E> next;

public E getInfo() {
    return info; 
}

public void setInfo(E info) {
    this.info = info;
}

public Node<E> getNext() {
    return next; 
}

public void setNext(Node<E> next) {
    this.next = next;
}

public Node(E info){
    this.info = info;
    this.next = null;
}
public Node(E info, Node<E> next){
    this.info = info;
    this.next = next;
}
}
