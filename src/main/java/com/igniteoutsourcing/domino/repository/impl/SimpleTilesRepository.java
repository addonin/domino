package com.igniteoutsourcing.domino.repository.impl;

import com.igniteoutsourcing.domino.domain.Tile;
import com.igniteoutsourcing.domino.domain.TileSet;
import com.igniteoutsourcing.domino.repository.TilesRepository;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SimpleTilesRepository implements TilesRepository {

    private TileSet tileSet = new TileSet();

    public List<Tile> getTiles(int n) {
        int counter = 0;
        List<Tile> toHand = new LinkedList<>();
        Iterator<Tile> iterator = tileSet.getAllTiles().iterator();
        while (iterator.hasNext() && counter++ < n) {
            toHand.add(iterator.next());
            iterator.remove();
        }
        return toHand;
    }

}
