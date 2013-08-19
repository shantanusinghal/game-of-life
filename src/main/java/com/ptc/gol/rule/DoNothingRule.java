package com.ptc.gol.rule;

import com.ptc.gol.Cell;

/**
 * Created with IntelliJ IDEA.
 * Author: Shantanu
 */
public class DoNothingRule implements Rule {

    @Override
    public Cell applyOn(Cell cell) {
        return cell;
    }
}
