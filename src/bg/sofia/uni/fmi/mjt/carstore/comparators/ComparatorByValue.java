package bg.sofia.uni.fmi.mjt.carstore.comparators;

import java.util.Comparator;

public class ComparatorByValue implements Comparator<Integer> {
    public int compare(Integer int1, Integer int2) {
        return Integer.compare(int1, int2);
    }
}
