package com.igniteoutsourcing.domino.repository;

import com.igniteoutsourcing.domino.domain.Tile;

import java.util.List;

public interface TilesRepository {

    List<Tile> getTiles(int n);

}
