import java.util.*;
import java.util.Scanner;
/**
 * Point βιβλιοθήκη που επιστρέφει την τοποθεσία του object(ships) 
 * στο board 
 */
import java.awt.Point;

public class Board {
    private static final Ship[] ships;
    private char[][] board;

    /**
     * καταγραφή τύπων πλοίων
     *
     */

    static {
        ships = new Ship[]{
                new Ship("Carrier", Constants.CARRIER_SIZE),
                new Ship("Battleship", Constants.BATTLESHIP_SIZE),
                new Ship("Cruiser", Constants.CRUISER_SIZE),
                new Ship("Submarine", Constants.SUBMARINE_SIZE),
                new Ship("Destroyer", Constants.DESTROYER_SIZE)
        };
    }


    /**
     * Constructors
     */
    public Board() {
        board = new char[Constants.BOARD_SIZE][Constants.BOARD_SIZE];

        for(int i = 0; i < Constants.BOARD_SIZE; i++) {
            for(int j = 0; j < Constants.BOARD_SIZE; j++) {
                board[i][j] = Constants.BOARD_ICON;
            }
        }
        printBoard();
        placeShipsOnBoard();
    }


    /**
     * χτυπημα πλοιου
     */
    public Ship targetShip(Point point) {
        boolean isHit = false;
        Ship hitShip = null;
        for(int i = 0; i < ships.length; i++) {
            Ship ship = ships[i];
            if(ship.getPosition() != null) {
                if(Utils.isPointBetween(point, ship.getPosition())) {
                    isHit = true;
                    hitShip = ship;
                    break;
                }

            }
        }
        final char result = isHit ? Constants.SHIP_IS_HIT_ICON : Constants.SHOT_MISSED_ICON;
        updateShipOnBoard(point, result);
        printBoard();

        return (isHit) ? hitShip : null;
    }

    /**
     * τοποθετηση πλοιων
     */
    private void placeShipsOnBoard() {
        System.out.printf("%nAlright - Time to place out your ships%n%n");
        Scanner s = new Scanner(System.in);

        for(int i = 0; i < ships.length; i++) {
            Ship ship = ships[i];
            boolean isShipPlacementLegal = false;

            System.out.printf("%nEnter position of %s (length  %d): ", ship.getName(), ship.getSize());

            while(!isShipPlacementLegal) {
                try {
                    Point from = new Point(s.nextInt(), s.nextInt());
                    Point to = new Point(s.nextInt(), s.nextInt());

                    while(ship.getSize() != Utils.distanceBetweenPoints(from, to)) {
                        System.out.printf("The ship currently being placed on the board is of length: %d. Change your coordinates and try again",
                                ship.getSize());

                        from = new Point(s.nextInt(), s.nextInt());
                        to = new Point(s.nextInt(), s.nextInt());
                    }
                    Position position = new Position(from, to);

                    if(!isPositionOccupied(position)) {
                        drawShipOnBoard(position);
                        ship.setPosition(position);
                        isShipPlacementLegal = true;
                    } else {
                        System.out.println("A ship in that position already exists - try again");
                    }

                } catch(IndexOutOfBoundsException e) {
                    System.out.println("Invalid coordinates - Outside board");
                }
            }
        }

    }


    private void updateShipOnBoard(Point point, final char result) {
        int x = (int) point.getX() - 1;
        int y = (int) point.getY() - 1;
        board[y][x] = result;
    }

    /**
     * δειχνει οτι εχει τοποθετηθει πλοιο
     * 
     */
    private boolean isPositionOccupied(Position position) {
        boolean isOccupied = false;
        Point from = position.getFrom();
        Point to = position.getTo();

        outer:
        for(int i = (int) from.getY() - 1; i < to.getY(); i++) {
            for(int j = (int) from.getX() - 1; j < to.getX(); j++) {
                if(board[i][j] == Constants.SHIP_ICON) {
                    isOccupied = true;
                    break outer;
                }
            }
        }


        return isOccupied;
    }

    
    private void drawShipOnBoard(Position position) {
        Point from = position.getFrom();
        Point to = position.getTo();
        for(int i = (int) from.getY() - 1; i < to.getY(); i++) {
            for(int j = (int) from.getX() - 1; j < to.getX(); j++) {
                board[i][j] = Constants.SHIP_ICON;
            }
        }
        printBoard();
    }


    /**
     * εμφανιζει το board.
     */
    private void printBoard() {
        System.out.print("\t");

        for(int i = 0; i < Constants.BOARD_SIZE; i++) {
            System.out.print(Constants.BOARD_LETTERS[i] + "\t");
        }

        System.out.println();

        for(int i = 0; i < Constants.BOARD_SIZE; i++) {
            System.out.print((i+1) + "\t");
            for(int j = 0; j < Constants.BOARD_SIZE; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
