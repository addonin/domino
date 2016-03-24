package com.igniteoutsourcing.domino.service;

import com.igniteoutsourcing.domino.domain.Chain;
import com.igniteoutsourcing.domino.domain.Tile;
import com.igniteoutsourcing.domino.service.impl.ChainAnalyser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimpleChainAnalyser implements ChainAnalyser {

    private List<Tile> analysedTiles;
    private List<Chain> chains = new ArrayList<>();

    public SimpleChainAnalyser(List<Tile> analysedTiles) {
        this.analysedTiles = analysedTiles;
    }

    @Override
    public List<Chain> analyse() {
        for (Tile tile : analysedTiles) {
            chains.add(composeChain(tile));
        }
        return chains;
    }

    private Chain composeChain(Tile firstTile) {
        Chain chain = new Chain(firstTile);
        Set<Tile> tilesToProcess = new HashSet<>(analysedTiles);
        tilesToProcess.remove(firstTile);
        //iterate composing chain with right logic
        return chain;
    }

}
