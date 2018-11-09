package bg.sofia.uni.fmi.mjt.carstore.exceptions;

public class CarNotFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public CarNotFoundException(){
        
    }
    public CarNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }

}
