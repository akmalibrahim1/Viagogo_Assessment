import java.util.HashMap;
import java.util.Random;

/**
 * Created by akmalibrahim on 5/6/17.
 */
public class EventLocater {

    private Graph graph;

    public EventLocater() {
        graph = new Graph();
    }

    /**
     * Seeds random data onto the graph
     */
    public void seedData() {
        Random rand = new Random();
        int eventCounter = 1;
        for(int i = 0; i<399; i++) {
            int x = rand.nextInt(2);
            if(x == 1) {
                graph.addEvent(eventCounter);
                eventCounter++;
            }
        }
    }

    /**
     * Find the 5 events closest to a given coordinate
     * @param x the x axis location of the user
     * @param y the y axis location of the user
     * @return EventDistance [] An array of 5 events
     */
    public EventDistance []  findEvents(int x, int y) {
         EventDistance [] ed = new EventDistance[5];
         int counter = 0;
         for(HashMap.Entry<Graph.Point, Event> p: graph.coordinates.entrySet()) {
            if(counter < 5) {
                EventDistance e = new EventDistance(graph.calculateDist(x, y, p.getKey().x, p.getKey().y), p.getValue());
                ed[counter] = e;
                counter++;
            } else {
                ed = sortDescending(ed);
                int tempdist = graph.calculateDist(x, y, p.getKey().x, p.getKey().y);
                if(ed[0].dist > tempdist){
                    EventDistance e = new EventDistance(tempdist, p.getValue());
                    ed[0] = e;
                }
            }
         }
         return ed;
    }

    /**
     * Sorts the list of events in descending order, so the furthest of the 5 events is first
     * @param events an array of EventDistance
     * @return the sorted array
     */
    public EventDistance [] sortDescending(EventDistance [] events) {
        for(int i = 0; i < events.length-1; i++) {
            for(int j = i+1; j<events.length; j++ ) {
                if(events[i].dist < events[j].dist) {
                    EventDistance ed = events[i];
                    events[i] = events[j];
                    events[j] = ed;
                }
            }
        }
        return events;
    }

    /**
     * Data wrapper class to group distance of an event to the actual event.
     */
    class EventDistance {
        int dist;
        Event event;

        public EventDistance (int dist, Event event){
            this.dist = dist;
            this.event = event;
        }
    }
}
