package com.igniteoutsourcing.domino;

import com.igniteoutsourcing.domino.repository.TilesRepository;
import com.igniteoutsourcing.domino.repository.impl.SimpleTilesRepository;
import com.igniteoutsourcing.domino.service.ConsoleAnalyseReporter;
import com.igniteoutsourcing.domino.service.ConsoleInputValidator;
import com.igniteoutsourcing.domino.service.SimpleChainAnalyser;
import com.igniteoutsourcing.domino.service.SimpleTilePicker;
import com.igniteoutsourcing.domino.service.impl.AnalyseReporter;
import com.igniteoutsourcing.domino.service.impl.ChainAnalyser;
import com.igniteoutsourcing.domino.service.impl.InputValidator;
import com.igniteoutsourcing.domino.service.impl.TilePicker;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        InputValidator validator = new ConsoleInputValidator();
        System.out.println("Input number of tiles to pick (1-49):");
        int n;
        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            input = scanner.nextLine();
        } while (!validator.isValid(input));
        n = Integer.parseInt(input);

        TilesRepository tilesRepository = new SimpleTilesRepository();
        TilePicker tilePicker = new SimpleTilePicker(tilesRepository);
        ChainAnalyser analyser = new SimpleChainAnalyser(tilePicker.pickTiles(n));
        AnalyseReporter reporter = new ConsoleAnalyseReporter();
        reporter.report(analyser.analyse());

    }

}
