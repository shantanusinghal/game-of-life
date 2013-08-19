package com.ptc.gol;

import com.ptc.gol.Cell;
import com.ptc.gol.Grid;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Created with IntelliJ IDEA.
 * Author: Shantanu
 */

public class GridSpecs {

    @Test
    public void itShouldReturnNeighboursOfGivenCell() {
        //Given
        Grid grid = new Grid();
        Cell cell4 = Cell.Factory.createLiveCellAt(1, 0);
        Cell cell5 = Cell.Factory.createLiveCellAt(1, 1);
        Cell cell6 = Cell.Factory.createLiveCellAt(1, 2);
        Cell cell7 = Cell.Factory.createLiveCellAt(2, 0);
        Cell cell8 = Cell.Factory.createLiveCellAt(2, 1);
        Cell cell9 = Cell.Factory.createLiveCellAt(2, 2);
        grid.setCells(Arrays.asList(cell4, cell5, cell6, cell7, cell8, cell9));

        //When
        List<Cell> actualNeighbourCells = grid.neighboursOf(cell5);

        //Then
        List<Cell> expectedNeighbourCells = Arrays.asList(cell4, cell6, cell7, cell8, cell9);
        assertThat(actualNeighbourCells, is(expectedNeighbourCells));
    }

}
