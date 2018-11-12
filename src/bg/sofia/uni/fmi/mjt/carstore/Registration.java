package bg.sofia.uni.fmi.mjt.carstore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import bg.sofia.uni.fmi.mjt.carstore.enums.Region;
import bg.sofia.uni.fmi.mjt.carstore.exceptions.UnavailableNumberException;

public class Registration {
    
    String prefix = null;
    char sufix1;
    char sufix2;
    public static final int START_REG_NUMBER = 1000;
    int number = 0;
    
    public Registration(Region region){
        this.prefix = Region.getPrefix(region);
        this.sufix1 = charGenerator();
        this.sufix2 = charGenerator();
        try {
            this.number = nextAvailableNumber(region);
        } catch (UnavailableNumberException e) {
            e.printStackTrace(); 
        }
    }
    private char charGenerator() {
        Random r = new Random();
        char c = (char)(r.nextInt(26)+'A');
        return c;
    }
    public String toString() {
        return prefix + number + sufix1 + sufix2;
    }
    public int getRegNumber(){
        return this.number;
    }
    public String getPrefix(){
        return this.prefix;
    }
    public static boolean isValidNumber(int number){
        return (number >= START_REG_NUMBER && number <=9999);
    }
    public int nextAvailableNumber(Region region) throws UnavailableNumberException {
        String reg = Region.getPrefix(region);
        ArrayList<Integer> available = new ArrayList<>();
           for (Registration r : CarStore.registrationNumbers){
               if (r.getPrefix().equals(reg)) { 
                   available.add(r.getRegNumber());
               } 
           }
           int maxValue = 0;
           if (!available.isEmpty()) {
               maxValue = Collections.max(available);
               if (Registration.isValidNumber(maxValue))  
                   return maxValue+1;
               throw new UnavailableNumberException("Not Available Reg Number " + maxValue ) ; 
           } else {
           return maxValue = Registration.START_REG_NUMBER;}
    }
}
