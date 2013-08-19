game-of-life
============

Java implementation of Conway's Game of Life.  

# How to build

To build the project, execute the following Maven command:

    mvn clean package
    
This will create a runnable JAR in target directory (eg. target/GameOfLife-1.0-SUPER.jar) that contains all dependencies.

# How to execute

To execute the JAR from command line:

    java -jar GameOfLife-1.0-SUPER.jar --sleep=1000 --iter=5 --file=C:\\Blinker.txt
    
# Command line arguments

##Required

    --file=FILE
    Specify the starting state of the grid in a file. 
    1s and 0s denote a live and a dead cell respectively.
    eg.
    0 0 0 0 0
    0 0 0 0 0
    0 1 1 1 0
    0 0 0 0 0
    0 0 0 0 0

##Optional

    --sleep=X
       Number of milliseconds between consecutive ticks.
       (default value: 6000)
    --iter=X
       The number of iterations that will be executed.
       (default value: infinite)
