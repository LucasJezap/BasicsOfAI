package game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Simple implementation of Gameplay class which is the heart of the game. It's task is to go through
 * fixed number of same tasks at the given rate (it's simply frames per second - FPS). In this class,
 * the task is simple - change our 2d grid to the next grid which is the result of applying one step of
 * Game of Life. The rules are described briefly in LogicSolver class.
 */
class Gameplay {

    /*
     * timeline - a static object of Timeline class. It's unique for every game and made static so that
     * other classes in the same package could manipulate it (for example stop after appropriate keyboard press).
     */
    static Timeline timeline;

    /**
     * A simple method which initializes timeline with Timeline object with given frames per second, appropriate
     * task to do in every cycle and number of cycles. After initialization the program waits for appropriate
     * keyboard key to be pressed in order to start the loop.
     */
    void play() {
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1.0 / Main.framesPerSecond), e -> SceneChanger.changeScene())
        );
        timeline.setCycleCount(Main.cycleLength);
        Gameplay.timeline.play();
    }
}
