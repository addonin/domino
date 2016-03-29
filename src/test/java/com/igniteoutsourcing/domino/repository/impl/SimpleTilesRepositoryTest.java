package com.igniteoutsourcing.domino.repository.impl;

import com.igniteoutsourcing.domino.domain.Tile;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SimpleTilesRepositoryTest {

    public static final int TILES_AMOUNT = 7;

    @Test
    public void shouldReturnExpectedTilesAmount() throws Exception {

        SimpleTilesRepository testedRepository = new SimpleTilesRepository();

        List<Tile> tiles = testedRepository.getTiles(TILES_AMOUNT);

        assertEquals("Unexpected amount of tiles", TILES_AMOUNT, tiles.size());
    }

}