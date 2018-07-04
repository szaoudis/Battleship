import java.util.*;
import java.util.Scanner;
import java.awt.Point;

public class Position {
    private Point from;
    private Point to;

    /**
     * Δημιουργούμε μια if σε περιπτωση που το πλοιο τοποθετηθει
     * εκτος ορίων
     */
    public Position(Point from, Point to) {
        if(from.getX() > Constants.BOARD_SIZE || from.getX() < 0
                || from.getY() > Constants.BOARD_SIZE || from.getY() < 0
                || to.getX() > Constants.BOARD_SIZE || to.getX() < 0
                || to.getY() > Constants.BOARD_SIZE || to.getY() < 0) {
            throw new ArrayIndexOutOfBoundsException();
        };

        this.from = from;
        this.to = to;
    }

    /**
     * δημιουργώ δύο μεθόδους που βοηθούν στη 
     * τοποθέτηση των πλοιών 
     * getFrom() απο ένα σημειο (x, y) μεχρι getTo ενα σημείο (x', y')
     */
    public Point getFrom() {
        return from;
    }


    public Point getTo() {
        return to;
    }
}