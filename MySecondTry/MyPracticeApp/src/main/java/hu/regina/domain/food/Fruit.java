package hu.regina.domain;

public class Fruit extends Food {

    int sugarLevel;


    @Override
    public int getFeedingValue() {
        return 0;
    }
}
