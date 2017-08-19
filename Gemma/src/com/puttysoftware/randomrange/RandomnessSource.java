package com.puttysoftware.randomrange;

import java.util.Random;

class RandomnessSource {
    // Fields
    private static Random SOURCE = null;

    // Constructor
    private RandomnessSource() {
        // Do nothing
    }

    // Methods
    private static Random getSource() {
        if (SOURCE == null) {
            SOURCE = new Random();
        }
        return SOURCE;
    }

    static int nextIntMax(int m) {
        return getSource().nextInt(m);
    }

    static int nextIntRaw() {
        return getSource().nextInt();
    }
}
