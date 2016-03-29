package com.igniteoutsourcing.domino.domain;

import java.util.Arrays;

public class Tile {

    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 6;

    private int[] values;

    public Tile(int i1, int i2) {
        if (i1 < MIN_VALUE || i1 > MAX_VALUE || i2 < MIN_VALUE || i2 > MAX_VALUE) {
            throw new IllegalArgumentException("Tile value should be 0...6");
        }
        this.values = new int[]{i1, i2};
    }

    public int[] getValues() {
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return Arrays.equals(values, tile.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }
}
