import java.util.List;

public class Edge<T, E>  {

    private final Vertex source;
    private final Vertex destination;
    private int distance;


    public Edge(Vertex source, Vertex destination, int distance) {
        this.distance = distance;
        this.source = source;
        this.destination = destination;

    }
    public int getDistance(){ return distance; }

    public Vertex getDestination() {
        return destination;
    }

    public Vertex getSource() {
        return source;
    }

    public String toString() {
        return source + " " + destination + "  " +  distance;
    }


}