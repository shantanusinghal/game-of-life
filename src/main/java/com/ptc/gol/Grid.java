package com.ptc.gol;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Author: Shantanu
 */

public class Grid {

    private List<Cell> cells;

    public Grid() {
        cells = new ArrayList<Cell>();
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public List<Cell> neighboursOf(Cell cell) {
        List<Cell> neighbours = new ArrayList<Cell>();
        for(int x = cell.getX(), row = x - 1; row <= x + 1; row++) {
            for (int y = cell.getY(), col = y -1; col <= y + 1; col ++) {
                if(row == x && col == y) {
                    continue;
                }
                Cell neighbourStub = Cell.Factory.createNullCellAt(row, col);
                if(gridContains(neighbourStub))
                    neighbours.add(cellFor(neighbourStub));
            }
        }
        return neighbours;
    }

    private boolean gridContains(Cell neighbour) {
        return cells.indexOf(neighbour) >= 0;
    }

    private Cell cellFor(Cell neighbour) {
        int index = cells.indexOf(neighbour);
        return cells.get(index);
    }
}
