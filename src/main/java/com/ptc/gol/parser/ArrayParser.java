package com.ptc.gol.parser;

import com.ptc.gol.Cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Author: Shantanu
 */
public class ArrayParser implements Parser {

    private final String SPACE = " ";
    Map<Boolean, String> values = new HashMap<Boolean, String>() {{
        put(true, "1");
        put(false, "0");
    }};

    @Override
    public List<Cell> parse(List<String> initialPattern) {
        List<Cell> parsedList = new ArrayList<Cell>();
        for (int rowIndex = 0; rowIndex < initialPattern.size(); rowIndex++) {
            String[] rowString = initialPattern.get(rowIndex).split(SPACE);
            for (int colIndex = 0; colIndex < rowString.length; colIndex++) {
                String cell = rowString[colIndex];
                if(isLive(cell)) {
                    parsedList.add(Cell.Factory.createLiveCellAt(rowIndex, colIndex));
                }
                else {
                    parsedList.add(Cell.Factory.createDeadCellAt(rowIndex, colIndex));
                }
            }
        }
        return parsedList;
    }

    @Override
    public String getPatternFrom(List<Cell> cells) {
        int currentRow = 0;
        StringBuilder pattern = new StringBuilder();
        for (Cell cell : cells) {
            currentRow = checkForNewRow(currentRow, pattern, cell);
            String cellValue = values.get(cell.isAlive());
            pattern.append(cellValue).append(" ");
        }
        removeTrailingSpaceFrom(pattern);
        return pattern.toString();
    }

    private int checkForNewRow(int currentRow, StringBuilder pattern, Cell cell) {
        int row = cell.getX();
        if(row > currentRow) {
            currentRow = row;
            removeTrailingSpaceFrom(pattern);
            pattern.append("\n");
        }
        return currentRow;
    }

    private void removeTrailingSpaceFrom(StringBuilder pattern) {
        int index = pattern.lastIndexOf(SPACE);
        pattern.deleteCharAt(index);
    }

//    @Override
//    public String getPatternFrom(List<Cell> cells) {
//        List<String> patternList = new ArrayList<String>();
//
//        int currentRow = -1;
//        for (Cell cell : cells) {
//            int row = cell.getX();
//            if(row > currentRow) {
//                currentRow = row;
//                patternList.add("");
//            }
//            String cellValue = values.get(cell.isAlive());
//            String modifiedRow = patternList.get(row).concat(" " + cellValue);
//            patternList.set(cell.getX(), modifiedRow);
//        }
//
//        StringBuilder pattern = new StringBuilder();
//        for (String row : patternList) {
//            pattern.append(row.trim()).append("\r\n");
//        }
//
//        return pattern.toString();
//    }

    private boolean isLive(String cellValue) {
        return cellValue.equals("1");
    }
}
