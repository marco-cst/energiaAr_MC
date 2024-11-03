package controller.tda.list;

import java.io.Serializable;

public class LinkedList<E> implements Serializable{
    private Node<E> header; // cabeceza, primer nodo
    private Node<E> last;   // Cola, último nodo de la lista
    private Integer size;
    

    public LinkedList() {
        this.header = null; 
        this.last = null; 
        this.size = 0;  
    }

    public Boolean isEmpty() {
        return (this.header == null || this.size == 0);
    }

    private void addHeader(E dato) {
        Node<E> help; 
        if (isEmpty()) {
            help = new Node<>(dato);  
            header = help;
            this.size++;
        } else {
            Node<E> healpHeader = this.header; 
            help = new Node<>(dato, healpHeader); 
            this.header = help;
        }
        this.size++;
    }

    private void addLast(E info) {
        Node<E> help;
        if (isEmpty()) {
            help = new Node<>(info);
            header = help;
            last = help;
        } else {
            help = new Node<>(info, null);
            last.setNext(help);
            last = help;
        }
        this.size++; 
    }

    public void add(E info){
        addLast(info);
    }

    private Node<E> getNode(Integer index) throws ListEmptyException, IndexOutOfBoundsException{
        if(isEmpty()){
            throw new ListEmptyException("Error, Lista vacia");
        } else if(index.intValue() < 0 || index.intValue() >= this.size){
            throw new IndexOutOfBoundsException("Error, fuera de rango");
        } else if (index.intValue() == (this.size - 1)){
            return last;
        } else{
            Node<E> search = header;
            int cont = 0;
            while(cont < index.intValue()){
                cont++;
                search = search.getNext();
            }
            return search;
        }
    }

    private E getFirst() throws ListEmptyException{
        if(isEmpty()){
            throw new ListEmptyException("Error, lista vacia");
        }
        return last.getInfo();
    }

    public E getLast() throws ListEmptyException{
        if(isEmpty()){
            throw new ListEmptyException("Error, Lista Vacia");
        }
        return last.getInfo();
    }

    public E get (Integer index) throws ListEmptyException, IndexOutOfBoundsException{
        if(isEmpty()){
            throw new ListEmptyException("Error, lista vacia");        
        } else if(index.intValue() < 0 || index.intValue() >= this.size.intValue()){
            throw new IndexOutOfBoundsException("Error, fuera de rango");
        } else if (index.intValue() == 0){
            return header.getInfo();
        } else if (index.intValue() == (this.size -1)){
            return last.getInfo();
        }else {
            Node<E> search = header;
            int cont = 0;
            while (cont < index.intValue()){
                cont++;
                search = search.getNext();
            }
            return search.getInfo();
        }
    }

    public void add(E info, Integer index) throws ListEmptyException, IndexOutOfBoundsException{
        if(isEmpty() || index.intValue() == 0) {
            addHeader(info);
        } else if (index.intValue() == this.size.intValue()){
            addLast(info);
        } else{
            Node<E> search_preview = getNode(index - 1);
            Node<E> search = getNode(index);
            Node<E> help = new Node<>(info, search);
            search_preview.setNext(help);
            this.size++;
        }
    }

    public void reset(){
        this.header = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(  "List data");
        try{
            Node<E> help = header;
            while(help != null){
                sb.append(help.getInfo()).append(" ->");
                help = help.getNext();
            }
        }catch (Exception e){
            sb.append(e.getMessage());
        }
        return sb.toString();
    }

    public Integer getSize(){
        return this.size;
    }
    public Node<E> getHeader() {
        return header;
    }


    public E[] toArray(){
        E[] matrix = null;
        if(!isEmpty()){
            Class clazz = header.getInfo().getClass(); 
            matrix = (E[])java.lang.reflect.Array.newInstance(clazz, size);
            Node<E> aux = header;
            for(int i = 0; i < this.size; i++){
                matrix[i] = aux.getInfo();
                aux = aux.getNext();
            }

        }
        return matrix;
    }
    
    @SuppressWarnings("unchecked")
    public E[] toList(Class<E> clazz) {
        E[] array = (E[]) java.lang.reflect.Array.newInstance(clazz, size);
        Node<E> current = header;
        int index = 0;
        while (current != null) {
            array[index++] = current.getInfo();
            current = current.getNext();
        }
        return array;
    }

    public LinkedList<E> toList(E[]matrix){
        reset();
    for (int i = 0; i < matrix.length; i++){
        this.add(matrix[i]); 
    }
    return this;
    }

    //borrar

    public int getLength() {
        return this.size.intValue();
    }

    private void removeLast() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Error delete, lista vacia.");
        } else {
            Node<E> nodo_last = getNode((getLength() - 2));
            nodo_last.setNext(null);
            this.last = nodo_last;
            this.size--;
        }
    }

    private void removeFirst() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Error delete, lista vacia.");
        } else {
            Node<E> nodo_first = header;
            Node<E> nodo_next_first = header.getNext();
            nodo_first.setNext(null);
            this.header = nodo_next_first;
            this.size--;
        }
    }

    public void remove(int index) throws ListEmptyException, IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ListEmptyException("Lista vacia, no puede eliminar elementos");
        } else if (index == 0) {
            removeFirst();
        } else if (index == (this.size - 1)) {
            removeLast();
        }
    }

}