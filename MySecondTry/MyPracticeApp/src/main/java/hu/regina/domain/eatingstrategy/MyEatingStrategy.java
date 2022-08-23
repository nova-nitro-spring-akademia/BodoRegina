package hu.regina.domain.eatingstrategy;

import hu.regina.domain.food.Food;

public enum MyEatingStrategy {

    FAT_RABBIT_STRATEGY{
        @Override
        public int execute(Food f) {
            System.out.println("Executing fat");
            FatRabbitEatingStrategy fatRabbitEatingStrategy = new FatRabbitEatingStrategy();
            return fatRabbitEatingStrategy.eatFood(f);
        }
    },

    NORMAL_RABBIT_STRATEGY{
        @Override
        public int execute(Food f) {
            System.out.println("Executing normal");
            NormalRabbitEatingStrategy normalRabbitEatingStrategy = new NormalRabbitEatingStrategy();
            return normalRabbitEatingStrategy.eatFood(f);
        }
    };

    public abstract int execute(Food f);
}

