package com.igniteoutsourcing.domino.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TileSetTest {

    public static final int INITIAL_TILESET_SIZE = 49;

    @Test
    public void shouldHaveKnownTilesAmount() throws Exception {
        assertEquals("Unexpected initial amount of tiles", INITIAL_TILESET_SIZE, new TileSet().getAllTiles().size());
    }

}