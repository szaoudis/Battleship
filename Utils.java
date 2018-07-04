import java.util.*;
import java.util.Scanner;
import java.awt.Point;

/**
 * βοηθητικο class για την λητουργια του παιχνιδιου
 * 
 */
public class Utils {

    private Utils() {

    }

    /**
     * αποσταση μεταξυ points double.
     * παραμετρος from
     * παραμετρος to
     * επιστροφη double
     */
    public static double distanceBetweenPoints(Point from, Point to) {
        double x1 = from.getX();
        double y1 = from.getY();
        double x2 = to.getX();
        double y2 = to.getY();

        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2)) + 1;
    }


    public static boolean isPointBetween(Point point, Position position) {
        Point from = position.getFrom();
        Point to = position.getTo();

        return from.getY() <= point.getY()
                && to.getY() >= point.getY()
                && from.getX() <= point.getX()
                && to.getX() >= point.getX();
    }

}