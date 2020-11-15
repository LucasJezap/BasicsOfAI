package game.scene;

import game.Main;
import game.objects.Hole;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

/**
 * Simple implementation of QueenBeeShuttlePattern class which main task is to set the initial
 * state of the game to the Queen Bee Shuttle pattern located in a random place on the 2d grid.
 */
public class GetStartingPattern {

    /**
     * A simple method constructing and returning the Scene with Queen Bee Shuttle pattern
     * located in a random place on it.
     *
     * @return Scene with Queen Bee Shuttle pattern
     */
    public static Scene getPattern() {
        GridPane grid = new GridPane();

        int leftGrassIndex = Main.leftGrassIndex;
        int rightGrassIndex = Main.rightGrassIndex;

        if (!Main.isHole && new Random().nextInt(10) == 1) {
            Main.hole = new Hole();
        } else if (Main.isHole) {
            Main.hole.move_hole();
        }

        for (int row = 0; row < Main.rowNum; row++) {
            for (int col = 0; col < Main.colNum; col++) {
                Rectangle rec = new Rectangle();
                rec.setWidth(Main.recSize);
                rec.setHeight(Main.recSize);

                Color color;

                if (row <= leftGrassIndex || row >= rightGrassIndex) {
                    color = Color.rgb(25 + new Random().nextInt(100),
                            160 + new Random().nextInt(95),
                            new Random().nextInt(100));
                } else if (Main.car.getCar().contains(row * Main.colNum + col))
                    color = Color.BLUE;
                else if (Main.isHole && Main.hole.getHole().contains(row * Main.colNum + col))
                    color = Color.WHITE;
                else if (row - leftGrassIndex < 4 || rightGrassIndex - row < 4)
                    color = Color.rgb(81, 81, 77);
                else if (row - leftGrassIndex < 5 || rightGrassIndex - row < 5)
                    color = Color.YELLOW;
                else if (row == 25 && col % 10 != 0 && col % 10 != 1 && col % 10 != 2 && col % 10 != 3)
                    color = Color.YELLOW;
                else
                    color = Color.rgb(81, 81, 77);

                rec.setFill(color);

                GridPane.setRowIndex(rec, row);
                GridPane.setColumnIndex(rec, col);
                grid.getChildren().addAll(rec);
            }
        }

        return new Scene(grid, Main.screenResolution.width, Main.screenResolution.height);
    }
}