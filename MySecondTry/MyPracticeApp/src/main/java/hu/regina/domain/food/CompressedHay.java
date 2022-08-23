package hu.regina.domain.food;

public class CompressedHay extends Food {

    private int fiberLevel;

    public CompressedHay(int nutritionalValue, int fiberLevel) {
        super(nutritionalValue);
        this.fiberLevel = fiberLevel;
    }

    @Override
    public int getFeedingValue() {
        return super.nutritionalValue + fiberLevel;
    }
}
