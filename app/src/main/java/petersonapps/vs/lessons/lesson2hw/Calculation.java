package petersonapps.vs.lessons.lesson2hw;

/**
 * Created by vs on 27.03.2017.
 */

public class Calculation {

    public static double calculate(String currentAction, double valueOne, double valueTwo) {

        switch (currentAction){
            case "+":
                return valueOne += valueTwo;

            case "-":
                return valueOne -= valueTwo;

            case "*":
                return valueOne *= valueTwo;

            case "/":
                return valueOne /= valueTwo;

            default:
                return Double.NaN;
        }
    }
}
