package com.igniteoutsourcing.domino.misc;

import com.igniteoutsourcing.domino.domain.Chain;
import com.igniteoutsourcing.domino.domain.Tile;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ChainComparatorTest {

    public static final String UNEXPECTED_RESULT = "Unexpected result for descending order comparation";

    private ChainComparator testedChainComparator = new ChainComparator();
    private Tile firstTile = new Tile(0, 0);
    private Chain chain1, chain2;

    @Before
    public void setUp() throws Exception {
        chain1 = new Chain(firstTile);
        chain2 = new Chain(firstTile);
    }

    @Test
    public void shouldCompareSameChains() throws Exception {
        assertTrue("", testedChainComparator.compare(chain1, chain2) == 0);
    }

    @Test
    public void shouldCompareDifferentLengthChains() throws Exception {

        Tile secondTile = new Tile(0, 1);
        chain1.connectToLeftFreeEnd(secondTile);

        int smallerResult = testedChainComparator.compare(chain1, chain2);
        int greaterResult = testedChainComparator.compare(chain2, chain1);

        assertTrue(UNEXPECTED_RESULT, smallerResult < 0);
        assertTrue(UNEXPECTED_RESULT, greaterResult > 0);
    }

}