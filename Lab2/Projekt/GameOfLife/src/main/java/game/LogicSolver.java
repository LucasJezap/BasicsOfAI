package game;

import java.util.ArrayList;

/**
 * Simple implementation of LogicSolver class which main task is to find the next sequence of points
 * on the 2d grid after applying one step of Game of Life to the current grid.
 * The rules of the Game of Life:
 * 1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.
 * 2. Any live cell with two or three live neighbours lives on to the next generation.
 * 3. Any live cell with more than three live neighbours dies, as if by overcrowding.
 * 4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
 */
class LogicSolver {

    /**
     * A simple method returning all cell's neighbours without boundary neighbours.
     * A viable neighbours have coordinates between (0 < row < rowSize,0 < col < colSize)
     *
     * @param row - x coordinate of the cell
     * @param col - y coordinate of the cell
     * @return CoordinatePoints object of all cell's neighbours
     */
    private static CoordinatePoints getAllNeighboursWithoutBoundaries(int row, int col) {
        int[] rows = {row - 1, row - 1, row - 1, row, row, row + 1, row + 1, row + 1};
        int[] cols = {col - 1, col, col + 1, col - 1, col + 1, col - 1, col, col + 1};

        return new CoordinatePoints(rows, cols);
    }

    /**
     * A simple method returning all cell's neighbours with boundary neighbours.
     * A viable neighbours have coordinates between (0 < row < rowSize,0 < col < colSize)
     * All unviable neighbours are changed to appropriate neighbours on the boundaries.
     *
     * @param row - x coordinate of the cell
     * @param col - y coordinate of the cell
     * @return CoordinatePoints object of all cell's neighbours
     */
    private static CoordinatePoints getAllNeighboursWithBoundaries(int row, int col) {
        int[] rows = {row - 1, row - 1, row - 1, row, row, row + 1, row + 1, row + 1};
        int[] cols = {col - 1, col, col + 1, col - 1, col + 1, col - 1, col, col + 1};

        for (int i = 0; i < rows.length; i++) {
            if (rows[i] < 0)
                rows[i] = Main.rowNum - 1;
            else if (rows[i] >= Main.rowNum)
                rows[i] = 0;

            if (cols[i] < 0)
                cols[i] = Main.colNum - 1;
            else if (cols[i] >= Main.colNum)
                cols[i] = 0;
        }

        return new CoordinatePoints(rows, cols);
    }

    /**
     * A simple method answering the question if cell will live on to the next generation.
     *
     * @param row        - x coordinate of the cell
     * @param col        - y coordinate of the cell
     * @param neighbours - CoordinatePoints object of all cell's neighbours
     * @return True if cell will live, False otherwise
     */
    static boolean isAlive(int row, int col, CoordinatePoints neighbours) {
        int aliveNeighbours = 0;

        for (int i = 0; i < neighbours.size; i++) {
            if (neighbours.rows[i] >= 0 && neighbours.rows[i] < Main.rowNum &&
                    neighbours.cols[i] >= 0 && neighbours.cols[i] < Main.colNum &&
                    Main.colorsArray.get(neighbours.rows[i] * Main.colNum + neighbours.cols[i]))
                aliveNeighbours += 1;
        }

        if (Main.colorsArray.get(row * Main.colNum + col)) {
            return aliveNeighbours > 1 && aliveNeighbours < 4;
        } else {
            return aliveNeighbours == 3;
        }
    }

    /**
     * A simple method checking for every cell on the grid it's state in the next generation.
     * It updates appropriate static object in Main class.
     */
    @SuppressWarnings("unchecked")
    static void generateNextSequence() {
        ArrayList<Boolean> nextSequence = (ArrayList<Boolean>) Main.colorsArray.clone();

        for (int row = 0; row < Main.rowNum; row++) {
            for (int col = 0; col < Main.colNum; col++) {
                CoordinatePoints neighbours;

                if (Main.allowNeighbours)
                    neighbours = getAllNeighboursWithBoundaries(row, col);
                else
                    neighbours = getAllNeighboursWithoutBoundaries(row, col);

                nextSequence.set(row * Main.colNum + col, isAlive(row, col, neighbours));
            }
        }

        Main.colorsArray = nextSequence;
    }
}
