import java.util.*;
import java.util.Scanner;
/**
 * ζωες, μεγεθοι πλοιων, γραμματα πινακα
 * 
 */
public class Constants {

    private Constants() {}

    public static final int PLAYER_LIVES = 17; //sum of all the ships

    public static final int CARRIER_SIZE = 5;
    public static final int BATTLESHIP_SIZE = 4;
    public static final int CRUISER_SIZE = 3;
    public static final int SUBMARINE_SIZE = 3;
    public static final int DESTROYER_SIZE = 2;

    public static final char SHIP_ICON = 'S';
    public static final char BOARD_ICON = '~';
    public static final char SHIP_IS_HIT_ICON = 'χ';
    public static final char SHOT_MISSED_ICON = 'M';

    public static final String[] BOARD_LETTERS = {"1", "2", "3", "4", "5", "6", "7"};
    public static final int BOARD_SIZE = 7;
}