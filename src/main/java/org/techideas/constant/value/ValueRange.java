package org.techideas.constant.value;

public enum ValueRange {

    MIN_VALUE(0),
    MAX_VALUE(100);

    final int value;

    ValueRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
