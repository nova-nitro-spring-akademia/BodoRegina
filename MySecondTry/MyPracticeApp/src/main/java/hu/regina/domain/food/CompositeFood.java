package hu.regina.domain;

import java.util.List;

public class CompositeFood extends Food {

    private final List<Food> containedFood;

    public CompositeFood(List<Food> containedFood) {
        this.containedFood = containedFood;
    }

    @Override
    public int getFeedingValue() {
        return containedFood.stream().map( food -> getFeedingValue()).reduce(0, Integer::sum);
    }
}
