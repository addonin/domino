package com.igniteoutsourcing.domino.domain;

import java.util.*;

import static com.igniteoutsourcing.domino.domain.Tile.MAX_VALUE;
import static com.igniteoutsourcing.domino.domain.Tile.MIN_VALUE;

public class TileSet {

    private Set<Tile> tiles;

    public TileSet() {
        List<Tile> temp = new ArrayList<>();
        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            for (int j = MIN_VALUE; j <= MAX_VALUE; j++) {
                temp.add(new Tile(i, j));
            }
        }
        Collections.shuffle(temp);
        tiles = new HashSet<>(temp);
    }

    public Set<Tile> getAllTiles() {
        return tiles;
    }

}
