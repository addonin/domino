package com.igniteoutsourcing.domino.domain;

import java.util.LinkedList;
import java.util.List;

public class Chain {

    private int leftFreeEnd, rightFreeEnd;

    private List<Tile> tiles = new LinkedList<>();

    public Chain(Tile firstTile) {
        tiles.add(firstTile);
        this.leftFreeEnd = firstTile.getValues()[0];
        this.rightFreeEnd = firstTile.getValues()[1];
    }

    public int getLength() {
        return tiles.size();
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public boolean fitToLeftFreeEnd(Tile tile) {
        int[] values = tile.getValues();
        return values[0] == leftFreeEnd || values[1] == leftFreeEnd;
    }

    public boolean fitToRightFreeEnd(Tile tile) {
        int[] values = tile.getValues();
        return values[0] == rightFreeEnd || values[1] == rightFreeEnd;
    }

    public void connectToLeftFreeEnd(Tile tile) {
        tiles.add(0, tile);
        int[] values = tile.getValues();
        leftFreeEnd = (leftFreeEnd == values[0]) ? values[1] : values[0];
    }

    public void connectToRightFreeEnd(Tile tile) {
        tiles.add(tiles.size(), tile);
        int[] values = tile.getValues();
        rightFreeEnd = (rightFreeEnd == values[0]) ? values[1] : values[0];
    }

}
