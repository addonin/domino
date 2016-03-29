package com.igniteoutsourcing.domino.domain;

import java.util.*;

public class TileSet {

    private Set<Tile> tiles;

    public TileSet() {
        List<Tile> temp = new ArrayList<>();
        for (int i = Tile.MIN_VALUE; i <= Tile.MAX_VALUE; i++) {
            for (int j = Tile.MIN_VALUE; j <= Tile.MAX_VALUE; j++) {
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
