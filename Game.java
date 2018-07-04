import java.util.*;
import java.util.Scanner;

public class Game {
    private Player[] players;

    /**
     * αρχιζει το παιχνιδι.
     */
    public Game() {
        players = new Player[]{
                new Player(1),
                new Player(2)
        };
    }

    public void start() {
        int i = 0;
        int j = 1;
        int size = players.length;
        Player player = null;
        /**
         * μετραει τις ζωες του παικτη 
         * ωστε να δει αν ειναι > 0 για να αλλαξει σειρα
         * για διευκόλυνση τις ζωές των πλοίων τις άθροισα
         * και τις έβαλα ως συνολικές ζωές παικτών
         */
        while(players[0].getLives() > 0 && players[1].getLives() > 0) {
            players[i++ % size].turnToPlay(players[j++ % size]);
            player = (players[0].getLives() < players[1].getLives()) ?
                    players[1] :
                    players[0];
        }

        System.out.printf("Congrats Player %d, you won!",player.getId());
    }
    
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
