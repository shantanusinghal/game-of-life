package com.ptc.gol.parser;

import com.ptc.gol.Cell;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Created with IntelliJ IDEA.
 * Author: Shantanu
 */
public class ArrayParserSpecs {

    ArrayParser arrayParser;

    @Before
    public void setUp() throws Exception {
        arrayParser = new ArrayParser();
    }

    @Test
    public void itShouldParseInputPatternIntoList() {
        //Given
        List<String> inputPattern = new ArrayList<String>() {{
            add("1 0");
            add("0 1");
        }};

        //When
        List<Cell> actualParsedList = arrayParser.parse(inputPattern);

        //Then
        assertThat(actualParsedList.size(), equalTo(4));
        assertThat(actualParsedList.get(0).isAlive(), is(true));
        assertThat(actualParsedList.get(1).isAlive(), is(false));
        assertThat(actualParsedList.get(2).isAlive(), is(false));
        assertThat(actualParsedList.get(3).isAlive(), is(true));
    }

    @Test
    public void itShouldFormatGivenListToPattern() {
        //Given
        Cell cell1 = Cell.Factory.createLiveCellAt(0, 0);
        Cell cell2 = Cell.Factory.createDeadCellAt(0, 1);
        Cell cell3 = Cell.Factory.createDeadCellAt(1, 0);
        Cell cell4 = Cell.Factory.createLiveCellAt(1, 1);
        List<Cell> inputList = Arrays.asList(cell1, cell2, cell3, cell4);

        //When
        String actualPattern = arrayParser.getPatternFrom(inputList);

        //Then
        String expectedPattern = "1 0\n0 1";
        assertThat(actualPattern, is(expectedPattern));

    }


}
