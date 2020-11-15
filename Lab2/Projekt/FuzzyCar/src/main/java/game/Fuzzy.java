package game;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

public class Fuzzy {

    public static double getFuzzy(double left_distance,
                                  double hole_distance_horizontal, double front_distance) {
        try {
            String fileName =
                    "C:\\Users\\Bossg\\OneDrive\\Pulpit\\AGH semestr 5\\PSI\\Lab2\\Projekt\\FuzzyCar\\fuzzy.fcl";
            FIS fis = FIS.load(fileName, false);
            FuzzyRuleSet fuzzyRuleSet = fis.getFuzzyRuleSet();

            fuzzyRuleSet.setVariable("left_distance", left_distance);
            fuzzyRuleSet.setVariable("hole_distance_horizontal", hole_distance_horizontal);
            fuzzyRuleSet.setVariable("front_distance", front_distance);
            fuzzyRuleSet.evaluate();

            return fuzzyRuleSet.getVariable("car_turning").defuzzify();

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        return 50.0;
    }

}
