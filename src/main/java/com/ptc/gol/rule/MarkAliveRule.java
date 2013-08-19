package com.ptc.gol.rule;

import com.ptc.gol.Cell;

/**
 * Created with IntelliJ IDEA.
 * Author: Shantanu
 */
public class MarkAliveRule implements Rule {
    @Override
    public Cell applyOn(Cell cell) {
        return Cell.Factory.createLiveCellAt(cell.getX(), cell.getY());
    }
}
