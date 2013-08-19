package com.ptc.gol;

import com.ptc.gol.parser.*;
import com.ptc.gol.rule.*;

import java.io.Console;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
* Created with IntelliJ IDEA.
* Author: Shantanu
*/
public class GameRunner {

    static private Grid grid;
    static private Parser parser;
    static private GameEngine engine;
    static private RuleFactory ruleFactory;
    static private Game gameOfLife;
    static private Arguments arguments;
    static private List<String> argErrors;

    public static void main(String[] args) {
        initWith(args);
        validateArguments();
        List<String> inputPattern = readFileInput();

        int iteration = 0;
        if (argErrors.isEmpty()) {
            gameOfLife.seed(inputPattern);

            while (isRemmaining(iteration)) {
                //output board
                System.out.println("\nIteration# " + iteration++);
                System.out.println(gameOfLife.snapshot());

                //iterate game state
                gameOfLife.tick();

                //sleep
                try {
                    Thread.sleep(arguments.sleep());
                }
                catch (InterruptedException ignored) {
                }
            }
        }
        else {
            for (String error : argErrors) {
                System.err.println(error);
            }
            System.exit(1);
        }
    }

    public static void initWith(String[] args) {
        grid = new Grid();
        parser = new ArrayParser();
        ruleFactory = new RuleFactory();
        engine = new GameEngine(ruleFactory);
        gameOfLife = new Game(parser, grid, engine);
        argErrors = new ArrayList<String>();
        arguments = new Arguments(args, argErrors);
    }

    private static boolean isRemmaining(int iteration) {
        return arguments.iterations() == -1 || iteration <= arguments.iterations();
    }

    private static void validateArguments() {
        String inputFile = arguments.file();
        if (inputFile == null) {
            argErrors.add("Input file is required (example: \"--file=input.txt\").");
        }
    }

    private static List<String> readFileInput() {
        List<String> input = new ArrayList<String>();
        try {
            Path filePath = Paths.get(arguments.file());
            input = Files.readAllLines(filePath, Charset.defaultCharset());
        } catch (Exception e) {
            argErrors.add("Input file not found at given path (Try specifying the Absolute Path).");
        }
        return input;
    }

}
