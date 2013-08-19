package com.ptc.gol;

import com.ptc.gol.parser.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Shantanu
 */
public class Game {

    private Grid grid;
    private Parser parser;
    private GameEngine engine;

    public Game(Parser parser, Grid grid, GameEngine engine) {
        this.grid = grid;
        this.parser = parser;
        this.engine = engine;
    }

    public void seed(List<String> initialPattern) {
        List<Cell> cells = parser.parse(initialPattern);
        grid.setCells(cells);
    }

    public void tick() {
        List<Cell> nextGenerationCells = engine.getNextGenerationOf(grid);
        grid.setCells(nextGenerationCells);
    }

    public String snapshot() {
        List<Cell> cells = grid.getCells();
        return parser.getPatternFrom(cells);
    }

}
