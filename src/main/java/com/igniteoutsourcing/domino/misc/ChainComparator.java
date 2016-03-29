package com.igniteoutsourcing.domino.misc;

import com.igniteoutsourcing.domino.domain.Chain;

import java.util.Comparator;

public class ChainComparator implements Comparator<Chain> {

    @Override
    public int compare(Chain o1, Chain o2) {
        return o2.getLength() - o1.getLength();
    }

}
