package game;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

/**
 * Simple implementation of Keyboard class which main task is to set the program to react to appropriate
 * keyboard keys and do appropriate stuff designed for such key.
 */
class Keyboard {

    /**
     * A simple method which set the program to react to appropriate keys in such a way:
     * Enter - start the game
     * Escape - close the game
     * Shift - switch between disallowing and allowing boundary neighbours
     */
    static void setEnterToStartGame() {
        Main.mainStage.getScene().setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Gameplay.timeline.play();
                Instruction.changeControl1();
            } else if (e.getCode() == KeyCode.ESCAPE) {
                Main.mainStage.close();
                Main.helpStage.close();
            } else if (e.getCode() == KeyCode.SHIFT) {
                Instruction.changeControl2();
            }
        });
    }

    /**
     * A simple method which set the program to react to appropriate keys in such a way:
     * Enter - restart the game and switch from current pattern to next pattern
     * Escape - close the game
     * Shift - switch between disallowing and allowing boundary neighbours
     */
    static void setEnterToChangeMode() {
        Main.mainStage.getScene().setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Gameplay.timeline.stop();
                Scene newScene;

                if (Main.currentPattern == Pattern.RANDOM) {
                    newScene = GetStartingPattern.getPattern();
                    Main.currentPattern = Pattern.QUEEN;
                    Main.mainStage.setTitle("Queen Bee Shuttle Pattern");
                } else if (Main.currentPattern == Pattern.QUEEN) {
                    newScene = GetStartingPattern.getPattern();
                    Main.currentPattern = Pattern.TUMBLER;
                    Main.mainStage.setTitle("Tumbler Pattern");
                } else {
                    newScene = GetStartingPattern.getPattern();
                    Main.currentPattern = Pattern.RANDOM;
                    Main.mainStage.setTitle("Random Pattern");
                }

                Main.mainStage.setScene(newScene);
                Instruction.changeControl1();
                setEnterToStartGame();

            } else if (e.getCode() == KeyCode.ESCAPE) {
                Main.mainStage.close();
                Main.helpStage.close();
            } else if (e.getCode() == KeyCode.SHIFT) {
                Instruction.changeControl2();
            }
        });
    }
}
