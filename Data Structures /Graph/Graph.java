import java.util.ArrayList;


public class Graph<T, E> {
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edgelist;

    public Graph() {

        this.vertices = new ArrayList<>();
        this.edgelist = new ArrayList<>();
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public ArrayList<Edge> getEdges() {
        return edgelist;
    }
    // returns all neighbours of a given vertex
    public ArrayList<Vertex> getNeighbours(Vertex<T> vertex) {

        ArrayList<Vertex> neighbours = new ArrayList<>();

        for (int i = 0; i < edgelist.size(); i++) {

            Edge edge = edgelist.get(i);
            if (edge.getSource().equals(vertex)) {
                neighbours.add(edge.getDestination());
            }
            if (edge.getDestination().equals(vertex)) {
                neighbours.add(edge.getSource());
            }
        }
        return neighbours;
    }
    // returns the edge that connects the vertices v1 and v2
    public Edge<T, E> getEdge(Vertex<T> vertex1, Vertex<T> vertex2) {

        for (int i = 0; i < edgelist.size(); i++) {

            Edge edge = edgelist.get(i);

            if (edge.getSource().equals(vertex1) && edge.getDestination().equals(vertex2)) {
                return edge;
            }
            if (edge.getSource().equals(vertex2) && edge.getDestination().equals(vertex1)) {
                return edge;
            }

        }
        return null;
    }
    public void addEdge(Edge<T, E> edge){

        this.edgelist.add(edge);

    }
}