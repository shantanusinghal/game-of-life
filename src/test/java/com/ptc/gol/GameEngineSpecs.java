package com.ptc.gol;

import com.ptc.gol.Cell;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import com.ptc.gol.rule.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * Author: Shantanu
 */

public class GameEngineSpecs {

    private Grid grid;
    private GameEngine gameEngine;
    private RuleFactory ruleFactory;

    @Before
    public void setUp() throws Exception {
        grid = new Grid();
        ruleFactory = new RuleFactory();
        gameEngine = new GameEngine(ruleFactory);
    }

    @Test
    public void itShouldReturnNextGenerationOfGrid() {
        //Given
        Cell cell1 = Cell.Factory.createDeadCellAt(0, 0);
        Cell cell2 = Cell.Factory.createDeadCellAt(0, 1);
        Cell cell3 = Cell.Factory.createDeadCellAt(0, 2);
        Cell cell4 = Cell.Factory.createDeadCellAt(1, 0);
        Cell cell6 = Cell.Factory.createDeadCellAt(1, 2);
        Cell cell7 = Cell.Factory.createDeadCellAt(2, 0);
        Cell cell8 = Cell.Factory.createDeadCellAt(2, 1);
        Cell cell9 = Cell.Factory.createDeadCellAt(2, 2);
        Cell liveCell5 = Cell.Factory.createLiveCellAt(1, 1);
        Cell deadCell5 = Cell.Factory.createLiveCellAt(1, 1);
        grid.setCells(Arrays.asList(cell1, cell2, cell3, cell4, liveCell5, cell6, cell7, cell8, cell9));

        //When
        List<Cell> actualNextGenerationCells = gameEngine.getNextGenerationOf(grid);

        //Then
        List<Cell> expectedNextGenerationCells = Arrays.asList(cell1, cell2, cell3, cell4, deadCell5, cell6, cell7, cell8, cell9);
        assertThat(actualNextGenerationCells, is(expectedNextGenerationCells));
    }

}
