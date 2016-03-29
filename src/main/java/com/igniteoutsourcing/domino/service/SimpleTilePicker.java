package com.igniteoutsourcing.domino.service;

import com.igniteoutsourcing.domino.domain.Tile;
import com.igniteoutsourcing.domino.repository.TilesRepository;
import com.igniteoutsourcing.domino.service.impl.TilePicker;

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
