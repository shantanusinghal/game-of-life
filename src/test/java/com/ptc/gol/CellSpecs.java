package com.ptc.gol;

import com.ptc.gol.Cell;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * Author: Shantanu
 */
public class CellSpecs {

    @Test
    public void itShouldSayAliveIfLiveCell() {
        //Given
        Cell liveCell = Cell.Factory.createLiveCellAt(0,0);
        //When
        boolean isAlive = liveCell.isAlive();
        //Then
        assertTrue(isAlive);
    }

    @Test
    public void itShouldSayNotAliveIfDeadCell() {
        //Given
        Cell deadCell = Cell.Factory.createDeadCellAt(0, 0);
        //When
        boolean isAlive = deadCell.isAlive();
        //Then
        assertFalse(isAlive);
    }

}
