package game.scene;

import javafx.scene.Scene;

class SceneGenerator {

    static Scene generateNextScene() {
        return GetStartingPattern.getPattern();
    }
}
