package com.igniteoutsourcing.domino.domain;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ChainTest {

    public static final int INITIAL_LENGTH = 1;
    public static final String UNEXPECTED_RESULT = "Unexpected result";

    private Tile firstTile = new Tile(0, 0);
    private Chain testedChain;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        testedChain = new Chain(firstTile);
    }

    @Test
    public void shouldHaveExpectedLength() throws Exception {
        assertEquals("New chain should have length " + INITIAL_LENGTH, INITIAL_LENGTH, testedChain.getLength());
    }

    @Test
    public void shouldHaveFirstTile() throws Exception {
        assertTrue("Chain should have first tile", testedChain.getTiles().contains(firstTile));
    }

    @Test
    public void shouldCheckAndConnectLeftFreeEndProperly() throws Exception {

        Tile suitableTile = new Tile(0, 1);
        Tile unsuitableTile = new Tile(1, 1);

        boolean suitableTileCheckResult = testedChain.fitToLeftFreeEnd(suitableTile);
        boolean unsuitableTileCheckResult = testedChain.fitToLeftFreeEnd(unsuitableTile);
        testedChain.connectToLeftFreeEnd(suitableTile);

        int leftEndIndex = 0;
        assertTrue(UNEXPECTED_RESULT, suitableTileCheckResult);
        assertFalse(UNEXPECTED_RESULT, unsuitableTileCheckResult);
        assertEquals("Should contain connected tile on left side", suitableTile, testedChain.getTiles().get(leftEndIndex));
    }

    @Test
    public void shouldCheckAndConnectRightFreeEndProperly() throws Exception {

        Tile suitableTile = new Tile(0, 1);
        Tile unsuitableTile = new Tile(1, 1);

        boolean suitableTileCheckResult = testedChain.fitToRightFreeEnd(suitableTile);
        boolean unsuitableTileCheckResult = testedChain.fitToRightFreeEnd(unsuitableTile);
        testedChain.connectToRightFreeEnd(suitableTile);

        int rightEndIndex = testedChain.getLength() - 1;
        assertTrue(UNEXPECTED_RESULT, suitableTileCheckResult);
        assertFalse(UNEXPECTED_RESULT, unsuitableTileCheckResult);
        assertEquals("Should contain connected tile on right side", suitableTile, testedChain.getTiles().get(rightEndIndex));
    }

    @Test
    public void shouldNotConnectWrongTilesToLeftEnd() throws Exception {
        Tile unsuitableTile = new Tile(1, 1);
        exception.expect(IllegalArgumentException.class);
        testedChain.connectToLeftFreeEnd(unsuitableTile);
    }

    @Test
    public void shouldNotConnectWrongTilesToRightEnd() throws Exception {
        Tile unsuitableTile = new Tile(1, 1);
        exception.expect(IllegalArgumentException.class);
        testedChain.connectToRightFreeEnd(unsuitableTile);
    }

}