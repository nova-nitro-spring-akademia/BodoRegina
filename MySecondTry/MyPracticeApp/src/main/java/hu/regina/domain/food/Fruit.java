package hu.regina.domain.food;

public class Fruit extends Food {

    private final int sugarLevel;

    public Fruit(int nutritionalValue, int sugarLevel) {
        super(nutritionalValue);
        this.sugarLevel = sugarLevel;
    }

    @Override
    public int getFeedingValue() {
        return nutritionalValue-sugarLevel;
    }
}
