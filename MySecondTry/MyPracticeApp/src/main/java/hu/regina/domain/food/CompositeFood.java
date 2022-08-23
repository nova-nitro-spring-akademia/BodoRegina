package hu.regina.domain.food;

import java.util.List;

public class CompositeFood extends Food {

    private List<Food> containedFood;

    public CompositeFood(List<Food> containedFood) {
        super(0);
        this.containedFood = containedFood;
    }



    @Override
    public int getFeedingValue() {
        int nutritionalValue = containedFood.stream().map( food -> getFeedingValue()).reduce(0, Integer::sum);
        super.setNutritionalValue(nutritionalValue);
        return nutritionalValue;
    }
}
