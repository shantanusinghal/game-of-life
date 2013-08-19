package com.ptc.gol;

import java.util.ArrayList;
import java.util.List;
import com.ptc.gol.rule.*;

/**
 * Created with IntelliJ IDEA.
 * Author: Shantanu
 */
public class GameEngine {

    private Grid grid;
    private RuleFactory ruleFactory;

    public GameEngine(RuleFactory ruleFactory) {
        this.ruleFactory = ruleFactory;
    }

    public List<Cell> getNextGenerationOf(Grid grid) {
        this.grid = grid;
        List<Cell> cells = grid.getCells();
        List<Cell> nextGenerationCells = new ArrayList<Cell>(cells);
        for (int index = 0; index < nextGenerationCells.size(); index++) {
            Cell cell = cells.get(index);
            Cell nextGenerationCell = getRuleFor(cell).applyOn(cell);
            nextGenerationCells.set(index, nextGenerationCell);
        }
        return nextGenerationCells;
    }

    private Rule getRuleFor(Cell cell) {
        return ruleFactory.ruleFor(cell.isAlive(), liveNeighbourCountOf(cell));
    }

    private int liveNeighbourCountOf(Cell cell) {
        int liveNeighbourCount = 0;
        for (Cell neighbour : grid.neighboursOf(cell)) {
            if (neighbour.isAlive()) liveNeighbourCount++;
        }
        return liveNeighbourCount;
    }

}
