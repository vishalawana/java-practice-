package generics;

class Calculator<T extends Number> {
    protected T value;

    public Calculator(T value) {
        this.value = value;
    }
}

class AdvancedCalculator<T extends Number>
        extends Calculator<T> {

    public AdvancedCalculator(T value) {
        super(value);
    }

    public double cube() {
        double v = value.doubleValue();
        return v * v * v;
    }
}

