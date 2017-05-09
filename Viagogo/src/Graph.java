import java.util.HashMap;
import java.util.Random;

/**
 * Created by akmalibrahim on 5/6/17.
 */
public class Graph {

    static final int maxY = 10;
    static final int maxX = 10;
    static final int minY = -10;
    static final int minX = -10;
    private Random rand;
    HashMap <Point, Event> coordinates;

    public Graph () {
        coordinates = new HashMap<>();
        rand = new Random();
    }

    /**
     * Adds an event to the graph
     * @param id the unique identification number for the event
     */
    public void addEvent(int id) {
        Event e = new Event(id, rand.nextInt(108000));
        //calculate the x axis
        int x = rand.nextInt(21) - 10;
        //calculate the y axis
        int y = rand.nextInt(21) - 10;

        if(check(x, y) == false) {
            Point p = new Point (x, y);
            coordinates.put(p, e);
        } else {

        }
    }

    /**
     * Checks if the coordinate already has an event or not
     * @param x event location x axis
     * @param y event location y axis
     * @return boolean will return true if there is an existing event
     */
    public boolean check (int x, int y) {
        for(Point p: coordinates.keySet()) {
            if(p.x == x && p.y == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * Calculates the manhattan distance between the user and the event
     * @param ux user x axis location
     * @param uy user y axis location
     * @param ex event x axis location
     * @param ey event y axis location
     * @return int the manhattan distance
     */
    public int calculateDist(int ux, int uy, int ex, int ey) {
        return Math.abs(ux - ex) + Math.abs(uy - ey);
    }

    /**
     * Internal class as a data wrapper to note down 2 points
     */
    public class Point {
        int x;
        int y;

        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
