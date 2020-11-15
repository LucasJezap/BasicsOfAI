package game;

import game.objects.Car;
import game.objects.Hole;
import game.scene.Gameplay;
import game.scene.GetStartingPattern;
import javafx.animation.Animation;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    public static Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
    public static Stage mainStage;
    public static int cycleLength = Animation.INDEFINITE;
    public static int rowNum = 50;
    public static int colNum = 96;
    public static int recSize;
    public static int framesPerSecond = 15;
    public static boolean isHole;
    public static Car car;
    public static Hole hole;
    public static int leftGrassIndex = 10;
    public static int rightGrassIndex = 40;
    public static int errorCount = 0;
    public static int holeCount = 0;

    public void start(Stage primaryStage) {
        mainStage = primaryStage;
        car = new Car();
        hole = new Hole();
        recSize = (screenResolution.height - 50) / rowNum;

        Scene firstScene = GetStartingPattern.getPattern();
        mainStage.setTitle("Fuzzy Logic - Car");
        mainStage.setScene(firstScene);
        mainStage.setX(0);
        mainStage.setY(0);
        mainStage.show();

        Gameplay gp = new Gameplay();
        gp.play();
    }

    public static void main(String[] args) {
        launch(args);
        Platform.exit();
        System.out.println("Number of holes: " + holeCount);
        System.out.println("Number of errors: " + errorCount);
        System.out.println("Error rate: " + 1.0 * errorCount / holeCount);
        System.exit(0);
    }
}

