package com.igniteoutsourcing.domino.service.impl;

import com.igniteoutsourcing.domino.domain.Tile;
import com.igniteoutsourcing.domino.repository.TilesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class SimpleTilePickerTest {

    public static final int TILES_AMOUNT = 1;

    @Mock
    private TilesRepository tilesRepositoryMock;

    @InjectMocks
    private SimpleTilePicker testedPicker;

    @Test
    public void shouldPickGivenAmountOfTiles() throws Exception {

        List<Tile> fakeTiles = new ArrayList<>(Collections.singletonList(new Tile(1, 1)));
        doReturn(fakeTiles).when(tilesRepositoryMock).getTiles(TILES_AMOUNT);

        List<Tile> result = testedPicker.pickTiles(TILES_AMOUNT);

        assertEquals("Unexpected result", fakeTiles, result);
    }

}