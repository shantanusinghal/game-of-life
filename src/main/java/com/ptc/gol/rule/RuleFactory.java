package com.ptc.gol.rule;

/**
 * Created with IntelliJ IDEA.
 * Author: Shantanu
 */
public class RuleFactory {

    public Rule ruleFor(boolean cellIsAlive, int liveNeighbours) {
        if(cellIsAlive) {
            if(moreThanTwo(liveNeighbours))
                return new MarkDeadRule();
            else if(twoToThree(liveNeighbours))
                return new MarkAliveRule();
            else if(moreThanThree(liveNeighbours))
                return new MarkDeadRule();
        }
        else {
            if(exactlyThree(liveNeighbours))
                return new MarkAliveRule();
        }
        return new DoNothingRule();
    }

    private boolean moreThanTwo(int c) { return c < 2; }
    private boolean exactlyThree(int c) { return c == 3; }
    private boolean moreThanThree(int c) { return c >3; }
    private boolean twoToThree(int c) { return c >=2 && c <=3; }

}
