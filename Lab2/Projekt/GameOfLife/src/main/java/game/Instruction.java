package game;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Simple implementation of Instruction class which main task is to prepare helping Stage with
 * instructions on how to play the Game of Life. Instruction stage should be opened in new window
 * next to the main window with the game.
 */
class Instruction {

    /*
     * control1 - Text object which changes throughout the game, informing about the use of Enter key
     * control2 - Text object which changes throughout the game, informing about the use of Shift key
     */
    static Text control1;
    static Text control2;

    /**
     * A simple method switching the text displayed by the control1 object between one informing about
     * how to start the game and one about how to change initial pattern.
     */
    static void changeControl1() {
        if (!Main.isStopped)
            control1.setText("● Enter - start game");
        else
            control1.setText("● Enter - change pattern");

        Main.isStopped = !Main.isStopped;
    }

    /**
     * A simple method switching the text displayed by the control2 object between one informing about
     * how to disallow boundary neighbours and one about how to allow them.
     */
    static void changeControl2() {
        if (!Main.allowNeighbours)
            control2.setText("● Shift - disallow boundary neighbours");
        else
            control2.setText("● Shift - allow boundary neighbours");

        Main.allowNeighbours = !Main.allowNeighbours;
    }

    /**
     * A simple method constructing the instruction Stage with appropriate Text objects informing about the
     * controls of the game.
     *
     * @return constructed instruction Stage object
     */
    static Stage getInstructionStage() {
        Stage helpStage = new Stage();
        helpStage.setTitle("Controls");

        Group root = new Group();
        final Scene helpScene = new Scene(root, 300, 300);

        final Text gameName = new Text(100, 50, "Welcome to Game of Life");
        gameName.setFill(Color.BLACK);
        gameName.setFont(Font.font(java.awt.Font.SERIF, 30));
        root.getChildren().add(gameName);

        control1 = new Text(100, 100, "● Enter - start game");
        control1.setFill(Color.BLACK);
        control1.setFont(Font.font(java.awt.Font.SERIF, 30));
        root.getChildren().add(control1);

        control2 = new Text(100, 150, "● Shift - allow boundary neighbours");
        control2.setFill(Color.BLACK);
        control2.setFont(Font.font(java.awt.Font.SERIF, 30));
        root.getChildren().add(control2);

        final Text control3 = new Text(100, 200, "● Esc - close game");
        control3.setFill(Color.BLACK);
        control3.setFont(Font.font(java.awt.Font.SERIF, 30));
        root.getChildren().add(control3);

        helpStage.setX(Main.recSize * Main.colNum + 100);
        helpStage.setWidth(600);
        helpStage.setHeight(300);
        helpStage.setScene(helpScene);

        return helpStage;
    }
}
