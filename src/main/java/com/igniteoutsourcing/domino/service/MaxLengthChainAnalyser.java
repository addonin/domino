package com.igniteoutsourcing.domino.service;

import com.igniteoutsourcing.domino.domain.Chain;
import com.igniteoutsourcing.domino.domain.Tile;
import com.igniteoutsourcing.domino.misc.ChainComparator;
import com.igniteoutsourcing.domino.service.impl.ChainAnalyser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxLengthChainAnalyser implements ChainAnalyser {

    private List<Tile> analysedTiles;
    private List<Chain> chains = new ArrayList<>();

    public MaxLengthChainAnalyser(List<Tile> analysedTiles) {
        this.analysedTiles = analysedTiles;
    }

    @Override
    public Chain analyse() {
        for (Tile tile : analysedTiles) {
            chains.add(composeChain(tile));
        }
        return findLongestChain(chains);
    }

    private Chain composeChain(Tile firstTile) {

        Chain chain = new Chain(firstTile);
        Set<Tile> tilesToProcess = new HashSet<>(analysedTiles);
        tilesToProcess.remove(firstTile);

        boolean successfulChain = true;
        while (successfulChain && tilesToProcess.size() > 0) {
            int chainLengthBefore = chain.getLength();
            for (Tile currentTile : tilesToProcess) {
                if (chain.fitToLeftFreeEnd(currentTile)) {
                    chain.connectToLeftFreeEnd(currentTile);
                    tilesToProcess.remove(currentTile);
                    break;
                }
                if (chain.fitToRightFreeEnd(currentTile)) {
                    chain.connectToRightFreeEnd(currentTile);
                    tilesToProcess.remove(currentTile);
                    break;
                }
            }
            if (chainLengthBefore == chain.getLength()) {
                successfulChain = false;
            }
        }

        return chain;
    }

    private Chain findLongestChain(List<Chain> chains) {
        chains.sort(new ChainComparator());
        return chains.get(0);
    }

}
