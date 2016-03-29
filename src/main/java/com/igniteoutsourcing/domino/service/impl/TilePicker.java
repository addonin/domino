package com.igniteoutsourcing.domino.service.impl;

import com.igniteoutsourcing.domino.domain.Tile;

import java.util.List;

public interface TilePicker {

    List<Tile> pickTiles(int n);

}
