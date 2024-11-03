package controller.tda.queque;

import controller.tda.Exception.OverFlowException;
import controller.tda.list.LinkedList;

public class QuequeOperation <E> extends LinkedList<E>{
    private Integer top;

    public QuequeOperation(Integer top){
        this.top = top;
    }

    public Boolean verify(){
        return getSize().intValue() <= top.intValue();
    }

    public void queque(E dato)throws Exception{
        if(verify()){
            add(dato, getSize());
        } else{
            throw new OverFlowException("Error, Cola llena");
        }
    }

    public E dequeque()throws Exception{
        if(isEmpty()){
            throw new Exception("Error, Cola vacia");
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
