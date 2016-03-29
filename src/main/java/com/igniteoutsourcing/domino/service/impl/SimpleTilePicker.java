package com.igniteoutsourcing.domino.service.impl;

import com.igniteoutsourcing.domino.domain.Tile;
import com.igniteoutsourcing.domino.repository.TilesRepository;
import com.igniteoutsourcing.domino.service.TilePicker;

import java.util.List;

public class SimpleTilePicker implements TilePicker {

    private TilesRepository tilesRepository;

    public SimpleTilePicker(TilesRepository tilesRepository) {
        this.tilesRepository = tilesRepository;
    }

    public List<Tile> pickTiles(int n) {
        return tilesRepository.getTiles(n);
    }

}
