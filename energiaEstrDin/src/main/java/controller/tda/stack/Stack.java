package controller.tda.stack;

public class Stack<E> {
    private StackOperation<E> stackOperation;

    public Stack(Integer cant){
        stackOperation = new StackOperation<>(cant);
    }

    public void push(E dato)throws Exception{
        stackOperation.push(dato);
    }

    public void getSize(){
        this.stackOperation.getSize();
    }
    
    public void clear(){
        this.stackOperation.reset();
    }

    public Integer getTop(){
        return stackOperation.getTop();
    }

    public void print(){
        System.out.println("Pila");
        System.out.println(stackOperation.toString());
        System.out.println("------------");
    }

    public E pop()throws Exception{
        return stackOperation.pop();
    }
}
