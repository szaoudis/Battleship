import java.util.*;
import java.util.Scanner;
import java.awt.Point;

public class Player {
    private int id;
    private int lives;
    private Board board;
    private Map<Point, Boolean> targetHistory;
    private Scanner scanner;

    /**
     * Μέθοδος απαραίτητη για τη δημιουργία των παικτών
     */
    public Player(int id) {
        System.out.printf("%n=== Setting up everything for Player %s ====", id);
        System.out.println("");
        this.id = id;
        this.lives = Constants.PLAYER_LIVES;
        this.board = new Board();
        this.targetHistory = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * το id του παικτη
     */
    public int getId() {
        return id;
    }

    /**
     *
     * επιστρεφει τις ζωες 
     */
    public int getLives() {
        return lives;
    }

    /**
     * μειωνει ζωή κατα 1.
     */
    public void decrementLiveByOne() {
        lives--;
    }

    /**
     * μεθοδος για να δειχνει τη σειρα του παικτη
     */
    public void turnToPlay(Player opponent) {
        System.out.printf("%n%nPlayer %d, Choose coordinates you want to hit (x y) ", id);
        Point point = new Point(scanner.nextInt(), scanner.nextInt());

        while(targetHistory.get(point) != null) {
            System.out.print("This position has already been tried");
            point = new Point(scanner.nextInt(), scanner.nextInt());
        }

        attack(point, opponent);
    }

    /**
     * η επιλογη του παικτη να επιτεθει και τα αποτελεσματα 
     * του χτυπηματος
     */
    private void attack(Point point, Player     opponent) {
        Ship ship = opponent.board.targetShip(point);
        boolean isShipHit = (ship != null) ? true : false;

        if(isShipHit) {
            ship.shipWasHit();
            opponent.decrementLiveByOne();
        }
        targetHistory.put(point, isShipHit);
        System.out.printf("Player %d, targets (%d, %d)",
                id,
                (int)point.getX(),
                (int)point.getY());
        System.out.println("...and " + ((isShipHit) ? "HITS!" : "misses..."));
    }
}