package com.igniteoutsourcing.domino.service;

import com.igniteoutsourcing.domino.domain.Tile;

import java.util.List;

public interface TilePicker {

    List<Tile> pickTiles(int n);

}
