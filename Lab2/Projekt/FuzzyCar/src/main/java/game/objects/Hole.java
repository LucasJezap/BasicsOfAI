package game.objects;

import game.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Hole {
    protected final int holeSize = 3;
    /* speed should be lower than 5 */
    protected final int holeSpeed = 3;

    protected int holeCount = 0;
    protected ArrayList<Integer> hole = new ArrayList<>(Collections.nCopies(holeSize * holeSize, -1));

    public Hole() {
        Main.holeCount += 1;
        Main.isHole = true;
        int tmp = Main.leftGrassIndex + 1 +
                new Random().nextInt(Main.rightGrassIndex - Main.leftGrassIndex - holeSize);
        for (int i = 0; i < holeSize; i++)
            for (int j = 0; j < holeSize; j++)
                hole.set((i * holeSize + j), (tmp + i) * Main.colNum + Main.colNum - j - 1);
    }

    public void move_hole() {
        for (int i = 0; i < hole.size(); i++)
            hole.set(i, hole.get(i) - holeSpeed);
        holeCount += holeSpeed;
        if (holeCount + 2 >= Main.colNum) {
            holeCount = 0;
            Main.isHole = false;
        }
    }

    public int getHoleSize() {
        return holeSize;
    }

    public ArrayList<Integer> getHole() {
        return hole;
    }

    public void setHole(final ArrayList<Integer> hole) {
        this.hole = hole;
    }
}
