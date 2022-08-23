package hu.regina.domain.food;

public abstract class Food {

    int nutritionalValue;

    public Food(int nutritionalValue) {
        this.nutritionalValue = nutritionalValue;
    }

    public int getNutritionalValue() {
        return nutritionalValue;
    }

    public void setNutritionalValue(int nutritionalValue) {
        this.nutritionalValue = nutritionalValue;
    }

    abstract public int getFeedingValue();

}
