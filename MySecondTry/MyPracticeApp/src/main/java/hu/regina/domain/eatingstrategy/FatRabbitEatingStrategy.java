package hu.regina.domain.eatingstrategy;

import hu.regina.domain.food.Food;

public class FatRabbitEatingStrategy implements EatingStrategy{

    @Override
    public int eatFood(Food food) {
        return food.getFeedingValue();
    }

}
