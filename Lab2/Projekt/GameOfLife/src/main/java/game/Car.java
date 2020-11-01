package game;

import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

class Car {
    protected final int carSize = 4;
    protected int upper_row = 15;
    protected final int left_column = 15;
    protected final int left_upper_corner = upper_row * Main.colNum + left_column;
    protected ArrayList<Integer> car = new ArrayList<>(Collections.nCopies(carSize * carSize, -1));

    Car() {
        for (int i = 0; i < carSize; i++) {
            for (int j = 0; j < carSize; j++) {
                car.set(i * carSize + j, left_upper_corner + i * Main.colNum + j);
            }
        }
    }

    public void move_car(double defuzzy) {
        int rows;
        if (defuzzy <= 50)
            rows = -1;
        else
            rows = 1;
        upper_row += rows;
        for (int i=0; i<Math.pow(carSize, 2); i++)
            car.set(i, car.get(i) + rows * Main.colNum);
    }
}
