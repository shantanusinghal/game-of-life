package com.ptc.gol.rule;

import com.ptc.gol.Cell;

/**
 * Created with IntelliJ IDEA.
 * Author: Shantanu
 */
public class MarkDeadRule implements Rule {
    @Override
    public Cell applyOn(Cell cell) {
        return Cell.Factory.createDeadCellAt(cell.getX(), cell.getY());
    }
}
