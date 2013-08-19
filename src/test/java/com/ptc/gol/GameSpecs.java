package com.ptc.gol;

import com.ptc.gol.Cell;
import com.ptc.gol.Game;
import com.ptc.gol.GameEngine;
import com.ptc.gol.Grid;
import com.ptc.gol.parser.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * Author: Shantanu
 */

@RunWith(MockitoJUnitRunner.class)
public class GameSpecs {

    private Game game;
    @Mock private Grid grid;
    @Mock private Parser parser;
    @Mock private GameEngine gameEngine;

    @Before
    public void setUp() throws Exception {
        game = new Game(parser, grid, gameEngine);
    }

    @Test
    public void itShouldInitializeGridWithSeedPattern() {
        //Given
        @SuppressWarnings("unchecked")
        List<Cell> dummyCellList = mock(List.class);
        List<String> initialPattern = new ArrayList<String>();
        when(parser.parse(initialPattern)).thenReturn(dummyCellList);

        //When
        game.seed(initialPattern);

        //Then
        verify(parser).parse(initialPattern);
        verify(grid).setCells(dummyCellList);
    }

    @Test
    public void itShouldReturnCurrentSnapshotOfGrid() {
        //Given
        @SuppressWarnings("unchecked")
        List<Cell> dummyCellList = mock(List.class);
        String expectedSnapshot = "";
        when(grid.getCells()).thenReturn(dummyCellList);
        when(parser.getPatternFrom(dummyCellList)).thenReturn(expectedSnapshot);

        //When
        String actualSnapshot = game.snapshot();

        //Then
        verify(grid).getCells();
        verify(parser).getPatternFrom(dummyCellList);
        assertThat(actualSnapshot, is(expectedSnapshot));
    }

    @Test
    public void itShouldSetGridToNextGenerationAtEachTick() {
        //Given
        @SuppressWarnings("unchecked")
        List<Cell> dummyNextGenerationCellList = mock(List.class);
        when(gameEngine.getNextGenerationOf(grid)).thenReturn(dummyNextGenerationCellList);

        //When
        game.tick();

        //Then
        verify(gameEngine).getNextGenerationOf(grid);
        verify(grid).setCells(dummyNextGenerationCellList);
    }
}
