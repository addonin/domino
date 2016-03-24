package com.igniteoutsourcing.domino.service;

import com.igniteoutsourcing.domino.domain.Chain;
import com.igniteoutsourcing.domino.domain.Tile;
import com.igniteoutsourcing.domino.service.impl.AnalyseReporter;

public class ConsoleAnalyseReporter implements AnalyseReporter {

    @Override
    public void report(Chain chain) {
        System.out.println("\nAnalyse report:");
        for (Tile tile : chain.getTiles()) {
            int[] values = tile.getValues();
            System.out.print(values[0] + "|" + values[1] + " ");
        }
    }

}
