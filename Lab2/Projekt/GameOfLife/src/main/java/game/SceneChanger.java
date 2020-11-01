package game;

import javafx.scene.Scene;

/**
 * Simple implementation of SceneChanger class which main task is to change game's state
 * in accordance with Game of Life rules. It also set's the program to react to appropriate
 * keyboard keys.
 */
class SceneChanger {

    /**
     * A simple method which generates Scene of the next state of the game and
     * set's the current state to this state. It also set's the program to react to appropriate
     * keyboard keys.
     */
    static void changeScene() {
        double left_distance = (Main.car.upper_row - Main.leftGrassIndex) * 100.0 /
                (Main.rightGrassIndex - Main.leftGrassIndex);
        double hole_distance_horizontal = 0.0;
        double front_distance = (Main.colNum - Main.car.left_column + Main.car.carSize) * 100.0 /
                (Main.colNum);
        if (Main.isHole) {
            int left_hole_col = Main.hole.get(0) % Main.colNum - Main.holeSize;
            int medium_hole_row = Main.hole.get(0) / Main.colNum + Main.holeSize / 2;
            hole_distance_horizontal = 50.0 + (medium_hole_row - Main.car.upper_row + Main.car.carSize / 2.0) * 50.0 /
                    (Main.rightGrassIndex - Main.leftGrassIndex);
            front_distance = (left_hole_col - Main.car.left_column + Main.car.carSize) * 100.0 /
                    (Main.colNum);
        }
        double car_turning = Fuzzy.getFuzzy(left_distance,
                hole_distance_horizontal, front_distance);

        System.out.println(left_distance + " " + hole_distance_horizontal + " " + front_distance);

        Main.car.move_car(car_turning);

        Scene updatedScene = SceneGenerator.generateNextScene();
        Main.mainStage.setScene(updatedScene);
    }

}
