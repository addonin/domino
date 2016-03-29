package com.igniteoutsourcing.domino.service.impl;

import com.igniteoutsourcing.domino.domain.Chain;
import com.igniteoutsourcing.domino.domain.Tile;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MaxLengthChainAnalyserTest {

    private MaxLengthChainAnalyser testedAnalyser;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldNotAnalyseNull() throws Exception {
        exception.expect(IllegalArgumentException.class);
        new MaxLengthChainAnalyser(null);
    }

    @Test
    public void shouldNotAnalyseEmptyTilesList() throws Exception {
        exception.expect(IllegalArgumentException.class);
        new MaxLengthChainAnalyser(Collections.emptyList());
    }

    @Test
    public void shouldReturnMaxLengthChain() throws Exception {

        List<Tile> analysedTiles = new ArrayList<>(Arrays.asList(
                new Tile(0, 1), new Tile(1, 2), new Tile(2, 3), new Tile(4, 5), new Tile(5, 6)));
        Chain expectedChain = new Chain(new Tile(0, 1));
        expectedChain.connectToRightFreeEnd(new Tile(1, 2));
        expectedChain.connectToRightFreeEnd(new Tile(2, 3));
        testedAnalyser = new MaxLengthChainAnalyser(analysedTiles);

        Chain result = testedAnalyser.analyse();

        List<Tile> expectedChainTiles = expectedChain.getTiles();
        List<Tile> resultChainTiles = result.getTiles();
        assertTrue("Unexpected result",
                expectedChainTiles.containsAll(resultChainTiles)
                        && resultChainTiles.containsAll(expectedChainTiles));
    }

}