package game;

import org.junit.Test;

import javafx.scene.paint.Color;

import static org.junit.Assert.*;

/**
 * Class testing CoordinatePoints class
 */
public class CoordinatePointsTest {

    @Test
    public void creatingNewCoordinatePointsTest() {
        int[] rows = {1, 2, 3, 4, 5};
        int[] cols = {5, 4, 3, 2, 1};
        CoordinatePoints cp = new CoordinatePoints(rows, cols);
        assertEquals(5, cp.size);
    }

    @Test(expected = IllegalArgumentException.class)
    public void errorWhenCreatingDifferentSizesCoordinatePointsTest() {
        int[] rows = {1, 2, 3, 4, 5};
        int[] cols = {5, 4, 3};
        CoordinatePoints cp = new CoordinatePoints(rows, cols);
        assertNull(cp.rows);
        assertNull(cp.cols);
    }

    @Test
    public void checkIfRightColorReturnedForPoints() {
        int[] rows = {1, 2, 3, 4, 5};
        int[] cols = {5, 4, 3, 2, 1};
        CoordinatePoints cp = new CoordinatePoints(rows, cols);
        assertEquals(Color.BLACK, cp.getColor(4, 2));
        assertEquals(Color.WHITE, cp.getColor(1, 4));
        assertEquals(Color.WHITE, cp.getColor(0, 0));
    }
}
