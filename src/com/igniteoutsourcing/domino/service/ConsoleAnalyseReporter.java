package com.igniteoutsourcing.domino.service;

import com.igniteoutsourcing.domino.domain.Chain;
import com.igniteoutsourcing.domino.domain.Tile;
import com.igniteoutsourcing.domino.misc.ChainComparator;
import com.igniteoutsourcing.domino.service.impl.AnalyseReporter;

import java.util.List;

public class ConsoleAnalyseReporter implements AnalyseReporter {

    @Override
    public void report(List<Chain> chains) {
        chains.sort(new ChainComparator());
        for (Chain chain : chains) {
            for (Tile tile : chain.getTiles()) {
                int[] values = tile.getValues();
                System.out.print(values[0] + "|" + values[1] + " ");
            }
            System.out.println(" ");
        }
    }
}
