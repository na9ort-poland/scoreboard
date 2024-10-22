package org.techideas.constant.value;

public enum ValueRange {

    MIN_VALUE(0),
    MAX_VALUE(10000);

    final int value;

    ValueRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean isNotValid(int value) {
        return value < MIN_VALUE.value || value > MAX_VALUE.value;
    }
}
