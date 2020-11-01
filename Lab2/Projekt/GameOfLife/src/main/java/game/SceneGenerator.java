package game;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Simple implementation of SceneGenerator class which main task is to create new Scene of
 * game's next state and return it so it can be used in SceneChange class.
 */
class SceneGenerator {

    /**
     * A simple method generating Scene of game's next state.
     * At first, it computes new colorsArray array with call to LogicSolver class.
     * Then it creates new scene based on colorsArray object.
     *
     * @return Scene of game's next state
     */
    static Scene generateNextScene() {
        return GetStartingPattern.getPattern();
    }
}
