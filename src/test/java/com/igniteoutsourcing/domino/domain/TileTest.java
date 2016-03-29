package com.igniteoutsourcing.domino.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class TileTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldNotCreateTileWithWrongValues() throws Exception {
        exception.expect(IllegalArgumentException.class);
        new Tile(-1, 7);
    }

    @Test
    public void shouldReturnExpectedValues() throws Exception {

        int value1 = 0, value2 = 1;

        Tile tile = new Tile(value1, value2);

        int[] values = tile.getValues();
        assertTrue("Should contain initial values", values[0] == value1 && values[1] == value2);
    }

}