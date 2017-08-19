package com.puttysoftware.randomrange;

public class RandomRange {
    // Fields
    private int minimum;
    private int maximum;

    // Constructor
    public RandomRange(int min, int max) {
        this.minimum = min;
        this.maximum = max;
    }

    // Methods
    public void setMinimum(int newMin) {
        this.minimum = newMin;
    }

    public void setMaximum(int newMax) {
        this.maximum = newMax;
    }

    public int generate() {
        if ((this.maximum - this.minimum + 1) < 0) {
            return generateNegative();
        } else {
            return generatePositive();
        }
    }

    public int generateRaw() {
        return RandomnessSource.nextIntRaw();
    }

    private int generatePositive() {
        return RandomnessSource.nextIntMax(this.maximum - this.minimum + 1)
                + this.minimum;
    }

    private int generateNegative() {
        return -(RandomnessSource.nextIntMax(-this.maximum + this.minimum - 1)
                - this.minimum);
    }
}
