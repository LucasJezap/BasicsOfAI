package game;

import javafx.scene.paint.Color;

/**
 * Simple implementation of CoordinatePoints class denoting a set of points on a 2d grid. The points are given in
 * (x,y) form. It's main use is to store the coordinates of all currently alive cells in the game.
 * It's naively implemented by two arrays of same length denoting rows and columns coordinates.
 * It's running time is O(n^2) where n is the number of rows/columns (the game is on square 2d grid).
 * However, given our limitations for row and column sizes we can effectively treat it as constant time (O(1)).
 */
class CoordinatePoints {
    /*
     * size - number of points in the set
     * rows - x coordinates of the points in the set
     * cols - y coordinates of the points in the set
     */
    int size;
    int[] rows;
    int[] cols;

    /**
     * A simple constructor of the CoordinatePoints class
     *
     * @param rows - x coordinates of the points to be inserted to the set
     * @param cols - y coordinates of the points to be inserted to the set
     */
    CoordinatePoints(int[] rows, int[] cols) {
        if (rows.length != cols.length)
            throw new IllegalArgumentException("The sizes are not equal!");
        this.size = rows.length;
        this.rows = rows;
        this.cols = cols;
    }

    /**
     * The main method of the CoordinatePoints class, it's a simple utility to check
     * if given point (row,col) is in set of points. It's running time is O(n^2) but with constant
     * n we can treat it as O(1).
     *
     * @param row - x coordinate of the point we want to check
     * @param col - y coordinate of the point we want to check
     * @return appropriate color from the Color class depending if point is in the set.
     * Returns Color.Black if point is present in set, Color.White otherwise.
     */
    Color getColor(int row, int col) {
        for (int i = 0; i < size; i++) {
            if (row == rows[i] && col == cols[i]) {
                return Color.BLACK;
            }
        }

        return Color.WHITE;
    }
}
