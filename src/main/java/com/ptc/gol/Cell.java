package com.ptc.gol;

import java.awt.Point;

/**
 * Created with IntelliJ IDEA.
 * Author: Shantanu
 */
public class Cell {

    private Point point;
    private CellState state;

    private Cell(Point point, CellState state) {
        this.point = point;
        this.state = state;
    }

    public int getX() {
        return point.x;
    }

    public int getY() {
        return point.y;
    }

    public boolean isAlive() {
        return state == CellState.ALIVE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return point.equals(cell.point);
    }

    @Override
    public int hashCode() {
        return point.hashCode();
    }

    public static class Factory {

        public static Cell createLiveCellAt(int row, int col) {
            return new Cell(new Point(row, col), CellState.ALIVE);
        }

        public static Cell createDeadCellAt(int row, int col) {
            return new Cell(new Point(row, col), CellState.DEAD);
        }

        public static Cell createNullCellAt(int row, int col) {
            return new Cell(new Point(row, col), CellState.NULL);
        }

    }
}
