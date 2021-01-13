package game.objects;

import game.Main;

import java.util.ArrayList;
import java.util.Collections;

public class Car {
    protected final int carSize = 4;
    private boolean checked = false;
    protected int upper_row = 15;
    protected final int left_column = 15;
    protected int left_upper_corner = upper_row * Main.colNum + left_column;
    protected ArrayList<Integer> car = new ArrayList<>(Collections.nCopies(carSize * carSize, -1));
    public Car() {
        for (int i = 0; i < carSize; i++) {
            for (int j = 0; j < carSize; j++) {
                car.set(i * carSize + j, left_upper_corner + i * Main.colNum + j);
            }
        }
    }

    public void move_car(double defuzzy) {
        int rows;
        if (defuzzy < 45)
            rows = -1;
        else if (defuzzy < 55)
            rows = 0;
        else
            rows = 1;
        upper_row += rows;
        left_upper_corner += rows * Main.colNum;
        for (int i=0; i<Math.pow(carSize, 2); i++)
            car.set(i, car.get(i) + rows * Main.colNum);
        check_error();
    }

    private void check_error() {
        if (!Main.isHole)
            checked = false;
        if (checked)
            return;
        for (int holeElement: Main.hole.getHole()) {
            if (car.contains(holeElement)) {
                Main.errorCount += 1;
                System.out.println("ERROR");
                checked = true;
                break;
            }
        }
    }

    public int getCarSize() {
        return carSize;
    }

    public int getUpper_row() {
        return upper_row;
    }

    public void setUpper_row(final int upper_row) {
        this.upper_row = upper_row;
    }

    public int getLeft_column() {
        return left_column;
    }

    public ArrayList<Integer> getCar() {
        return car;
    }

    public void setCar(final ArrayList<Integer> car) {
        this.car = car;
    }
}
