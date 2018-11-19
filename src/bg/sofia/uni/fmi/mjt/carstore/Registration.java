package bg.sofia.uni.fmi.mjt.carstore;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import bg.sofia.uni.fmi.mjt.carstore.comparators.ComparatorByValue;
import bg.sofia.uni.fmi.mjt.carstore.enums.Region;
import bg.sofia.uni.fmi.mjt.carstore.exceptions.UnavailableNumberException;

public class Registration {

    private String prefix = null;
    private char sufix1;
    private char sufix2;
    public static final int START_REG_NUMBER = 1000;
    private int number = 0;
    private ArrayList<Integer> numbersBuffer = new ArrayList<>();
    public static Map<String, ArrayList<Integer>> registrations = null;

    public Registration(Region region) throws UnavailableNumberException {

        this.prefix = Region.getPrefix(region);
        this.sufix1 = charGenerator();
        this.sufix2 = charGenerator();
        this.number = nextAvailableNumber(this.prefix);
        registrations.put(this.prefix, numbersBuffer);
    }

    private char charGenerator() {
        Random r = new Random();
        char c = (char) (r.nextInt(26) + 'A');
        return c;
    }

    public String toString() {
        return prefix + number + sufix1 + sufix2;
    }

    public int getRegNumber() {
        return this.number;
    }

    public String getPrefix() {
        return this.prefix;
    }

    private boolean isValidNumber(int number) {
        return (number >= START_REG_NUMBER && number <= 9999);
    }

    private int nextAvailableNumber(String prefix) throws UnavailableNumberException {
        if (registrations.get(prefix) != null)
            numbersBuffer.addAll(registrations.get(prefix));
        if (!numbersBuffer.isEmpty()) {
            numbersBuffer.sort(new ComparatorByValue());
            int maxValue = numbersBuffer.get(0);
            if (isValidNumber(maxValue + 1)) {
                numbersBuffer.add(maxValue + 1);
                return maxValue + 1;
            }
            throw new UnavailableNumberException();
        }
        return START_REG_NUMBER;
    }
}
