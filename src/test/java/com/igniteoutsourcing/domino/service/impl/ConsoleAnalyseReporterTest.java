package com.igniteoutsourcing.domino.service.impl;

import com.igniteoutsourcing.domino.domain.Chain;
import com.igniteoutsourcing.domino.domain.Tile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ConsoleAnalyseReporterTest {

    public static final String UNEXPECTED_OUTPUT = "Unexpected output";

    private ConsoleAnalyseReporter testedReporter = new ConsoleAnalyseReporter();
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }

    @Test
    public void shouldMakeExpectedReport() throws Exception {

        Tile firstTile = new Tile(0, 0);
        Chain chain = new Chain(firstTile);

        testedReporter.report(chain);

        assertEquals(UNEXPECTED_OUTPUT, "\nAnalyse report:\r\n0|0 ", outContent.toString());
    }

    @Test
    public void shouldNotMakeReport() throws Exception {

        Chain chain = null;

        testedReporter.report(chain);

        assertEquals(UNEXPECTED_OUTPUT, "", outContent.toString());
    }
}