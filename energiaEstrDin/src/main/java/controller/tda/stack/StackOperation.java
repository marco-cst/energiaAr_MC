package controller.tda.stack;

import controller.tda.Exception.OverFlowException;
import controller.tda.list.LinkedList;
import controller.tda.list.ListEmptyException;

public class StackOperation<E> extends LinkedList<E>{
    private Integer top;

    public StackOperation(Integer top){
        this.top = top;
    }

    public Boolean verify(){
        return getSize().intValue() <= top.intValue();
    }

    public void push(E dato)throws Exception{
        if(verify()){
            add(dato, 0);
        } else{
            throw new OverFlowException("Error, Pila lleno");
        }
    }

    public E pop()throws ListEmptyException{
        if(isEmpty()){
            throw new ListEmptyException("Error, Pila vacia");
        } else{
            return removeFirst();
        }
    }

    public Integer getTop(){
        return top;
    }

    public void setTop(Integer top){
        this.top = top;
    }
    
}
