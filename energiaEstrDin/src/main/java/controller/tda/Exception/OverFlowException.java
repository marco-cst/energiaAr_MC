package controller.tda.Exception;

public class OverFlowException extends Exception {
 
    public OverFlowException() {
    }

    /**
     * Constructor de la excepcion
     * @param msg mensaje de la excepcion
     */


    public OverFlowException(String msg) {
        super(msg);
    }
}
