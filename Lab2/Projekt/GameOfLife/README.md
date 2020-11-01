# Game Of Life
Java implementation of classic Conway's Game of Life. Tribute to John Horton Conway, let him rest in peace. 
# Table of Contents
- [Game of Life](#game-of-life)
- [Rules](#rules)
- [How does it work](#how-does-it-work)
- [Game features](#game-features)
- [Controls](#controls)
- [Start the Game](#start-the-game)
- [Switching between patterns](#switching-between-patterns)
- [Boundary Neighbours](#boundary-neighbours)
- [Closing the game](#closing-the-game)
- [Download](#download)
- [Implementation Details](#implementation-details)
- [Java Doc](#java-doc)
- [Credits](#credits)

# Game of Life
The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970. It is a zero-player game, meaning that its evolution is determined by its initial state, requiring no further input. One interacts with the Game of Life by creating an initial configuration and observing how it evolves  
# Rules
The universe of the Game of Life is an infinite, two-dimensional orthogonal grid of square cells, each of which is in one of two possible states, alive or dead, (or populated and unpopulated, respectively). Every cell interacts with its eight neighbours, which are the cells that are horizontally, vertically, or diagonally adjacent. At each step in time, the following transitions occur:  
  
- Any live cell with fewer than two live neighbours dies, as if by underpopulation.  
- Any live cell with two or three live neighbours lives on to the next generation.  
- Any live cell with more than three live neighbours dies, as if by overpopulation.  
- Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.  
  
These rules, which compare the behavior of the automaton to real life, can be condensed into the following:  
  
- Any live cell with two or three live neighbors survives.
- Any dead cell with three live neighbors becomes a live cell.
- All other live cells die in the next generation. Similarly, all other dead cells stay dead.  
  
The initial pattern constitutes the seed of the system. The first generation is created by applying the above rules simultaneously to every cell in the seed; births and deaths occur simultaneously, and the discrete moment at which this happens is sometimes called a tick. Each generation is a pure function of the preceding one. The rules continue to be applied repeatedly to create further generations.  
# How does it work
![](https://github.com/LucasJezap/ImagesAndSoOn/blob/master/golgif.gif)
# Game features
Basic implementation rules:  
  
- It's set on 2d grid of size 50x50  
- Frequency of the game is 30Hz  
- There are three different initial patterns that are used as a first generation of cells, which are listed below  
  
Developers may change this settings to their preferences as well as many other settings avalaible in the implementation.  
### Initial patterns:  
  
#### 1. Random Pattern
Every cell is random. There is a 50/50 chance for cell to be alive at the start.  
  
#### 2. The Queen Bee Shuttle Pattern
This pattern is generated in a random place on the grid.  
![Queen Bee](https://github.com/LucasJezap/GameOfLife/blob/master/photos/queen.png)  
  
#### 3. Tumbler Pattern  
This pattern is generated in a random place on the grid.  
![Tumbler](https://github.com/LucasJezap/GameOfLife/blob/master/photos/tumbler.png)  

# Controls
### Enter - start the game, change pattern  
### Shift - allow boundary neighbours, disallow boundary neighbours
### Escape - close the game

# Start the game
The player might start the game by pressing Enter once.  

# Switching between patterns
The player can switch between patterns at any time. Pressing Enter while the game is on results in game being  
stopped and initial pattern being switched to the next one.  
  
Pattern list:  
Random -> The Queen Bee Shuttle -> Tumbler -> Random -> ...  

# Boundary neighbours  
The player might decide to either allow or disallow boundary neighbours.  
  
The whole concept of boundary neighbours concerns cells which don't have 8 neighbours. In other words, they are on the grid's borders.  
  
We can either let those cells have less than 8 neighbours or attribute them with appropriate cells which would be in their neighbourhood
if we wrapped the grid.  
  
The player can change this setting dynamically throughout the game which allows many interesting situations and anomalies to happen.  
  
For example patterns which loop infinitely by coming back to initial pattern can be broken with putting walls on grid's borders.  
Tumbler pattern is one of such patterns.  

# Closing the game
The player might close the game by pressing Escape at any given time.

# Download
You can download the Java Executable [here](https://drive.google.com/open?id=1b6nFQHHutJBrWnUmRxj53BXJdXuImoPX).

# Implementation details
Project implemented in Java, especially JavaFX with Maven.  
Java version: 14  
Java IDE: IntelliJ IDEA  
Owner: Łukasz Jezapkowicz  

# Java doc
Java documentation can be seen in all source files.  
You can generate JavaDoc with any Java IDE e.g. Intellij IDEA by clicking Tools-> Generate JavaDoc... .

# Credits
Thanks to [Novomatic Technologies Poland S.A.](https://novomatic-tech.com/) for giving me the idea to make this
project.
