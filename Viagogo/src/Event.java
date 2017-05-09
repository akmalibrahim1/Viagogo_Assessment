import java.util.HashMap;
import java.util.Random;

/**
 * Created by akmalibrahim on 5/6/17.
 */
public class Event {

    private int id;
    private HashMap<Integer, Float> tickets;

    /**
     * Creates an event with some number of tickets each with a randomly
     * calculated price
     * @param id a unique numeric identifier for the event
     * @param tickets the number of tickets available for the event
     */
    public Event(int id, int tickets) {
        this.id = id;
        this.tickets = new HashMap<>();

        //sets random price for each ticket for the event
        Random rand = new Random();
        for(int i = 1; i<=tickets; i++) {
            Float f = rand.nextFloat();
            Integer p = rand.nextInt(75000) + 1;
            Float price = f + p;
            this.tickets.put(i, price);
        }
    }

    /**
     * Finds the cheapest ticket for the event
     * @return String the cheapest ticket in US Dollars
     */
    public String getCheapestTicket() {
        float cheapest = Float.MAX_VALUE;
        for(Float f : tickets.values()) {
            if(f < cheapest) {
                cheapest = f;
            }
        }
        return "$" + Math.round(cheapest*100.0)/100.0;
    }

    /**
     * Gets the unique numerical identifier for the event
     * @return id the unique ID
     */
    public int getID(){
        return id;
    }

}
