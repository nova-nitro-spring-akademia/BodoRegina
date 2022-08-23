package hu.regina.mapper;

import hu.regina.domain.eatingstrategy.EatingStrategy;
import hu.regina.domain.eatingstrategy.FatRabbitEatingStrategy;
import hu.regina.domain.eatingstrategy.NormalRabbitEatingStrategy;

public enum MyEatingStrategy {

    FAT_RABBIT_STRATEGY{
        @Override
        EatingStrategy execute() {
            System.out.println("Executing fat");
            return new FatRabbitEatingStrategy();
        }
    },

    NORMAL_RABBIT_STRATEGY{
        @Override
        EatingStrategy execute() {
            System.out.println("Executing normal");
            return new NormalRabbitEatingStrategy();
        }
    };

    public abstract EatingStrategy execute();
}

