package com.ptc.gol.parser;

import com.ptc.gol.Cell;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Shantanu
 */
public interface Parser {

    List<Cell> parse(List<String> initialPattern);
    String getPatternFrom(List<Cell> cells);
}
