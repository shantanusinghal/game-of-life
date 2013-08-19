package com.ptc.gol.rule;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * Author: Shantanu
 */
public class RuleBookSpecs {

    private RuleFactory ruleFactory;

    @Before
    public void setUp() throws Exception {
        ruleFactory = new RuleFactory();
    }

    @Test
    public void itShouldMarkLiveCellWithFewerThanTwoLiveNeighboursAsDead() {
        //Given
        boolean isAlive = true;
        //When
        Rule rule = ruleFactory.ruleFor(isAlive, 1);
        //Then
        assertTrue(rule instanceof MarkDeadRule);
    }

    @Test
    public void itShouldMarkLiveCellWithTwoOrThreeLiveNeighboursAsLive() {
        //Given
        boolean isAlive = true;
        //When
        Rule rule = ruleFactory.ruleFor(isAlive, 3);
        //Then
        assertTrue(rule instanceof MarkAliveRule);
    }

    @Test
    public void itShouldMarkLiveCellWithMoreThanThreeLiveNeighboursAsDead() {
        //Given
        boolean isAlive = true;
        //When
        Rule rule = ruleFactory.ruleFor(isAlive, 4);
        //Then
        assertTrue(rule instanceof MarkDeadRule);
    }

    @Test
    public void itShouldMarkDeadCellWithExactlyThreeLiveNeighboursAsAlive() {
        //Given
        boolean isDead = false;
        //When
        Rule rule = ruleFactory.ruleFor(isDead, 3);
        //Then
        assertTrue(rule instanceof MarkAliveRule);
    }

    @Test
    public void itShouldMarkDeadCellWithNotExactlyThreeLiveNeighboursAsIs() {
        //Given
        boolean isDead = false;
        //When
        Rule rule = ruleFactory.ruleFor(isDead, 4);
        //Then
        assertTrue(rule instanceof DoNothingRule);
    }

}
