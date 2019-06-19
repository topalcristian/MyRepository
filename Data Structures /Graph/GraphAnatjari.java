import java.util.ArrayList;

public class GraphAnatjari<T, E> {

    private int k = 0;
    private Graph graph;
    private ArrayList<ArrayList<Vertex>> allPaths = new ArrayList<>();


    public GraphAnatjari(int k, Graph graph) {

        this.k = k;
        this.graph = graph;

    }

    public void removeEdge() {

        ArrayList<Edge> edges = graph.getEdges();
        ArrayList<Edge> removedEdges = new ArrayList<>();

        for (int i = 0; i < edges.size(); i++) {

            Edge edge = edges.get(i);
            // if k is smaller than the distance, then remove edge, since we already know that he cannot walk this way
            if (edge.getDistance() > k) {
                removedEdges.add(edge);

            }
        }
        for (int i = 0; i < removedEdges.size(); i++) {

            edges.remove(removedEdges.get(i));
        }
        // remove vertex if it is not connected to any other vertices
        ArrayList<Vertex> vertexlist = graph.getVertices();

        for (int i = 0; i < vertexlist.size(); i++) {

            Vertex vertex = vertexlist.get(i);

            if (graph.getNeighbours(vertex).equals(null)) {
                vertexlist.remove(vertex);
            }
        }

    }

    //inspired by https://www.geeksforgeeks.org/find-paths-given-source-destination/
    public void findPaths(Vertex<String> source, Vertex<String> destination, ArrayList<Vertex> currentPath) {

        ArrayList<Vertex> newPath = new ArrayList<>();
        source.setVisit(true);
        System.out.println("ID:" + source.getId());
        //base case: if we arrive at our destination
        if (source.equals(destination)) {
            // then add current path to allPaths
            for (int i = 0; i < currentPath.size(); i++) {
                newPath.add(currentPath.get(i));
            }
            allPaths.add(newPath);
            source.setVisit(false);
            return;
        }
        ArrayList<Vertex> vertexNeighbours = graph.getNeighbours(source);

        for (int i = 0; i < vertexNeighbours.size(); i++) {
            Vertex vertex = vertexNeighbours.get(i);
            if (!vertex.isVisit()) {
                //recursive call
                currentPath.add(vertex);
                findPaths(vertex, destination, currentPath);

                currentPath.remove(vertex);
            }

        }
        source.setVisit(false);

    }

    // what is the shortest path? the least amount of stops or what?
    public ArrayList<Vertex> getShortestPath() {

        ArrayList<Vertex> currentPath = new ArrayList<>();
        ArrayList<Vertex> bestPath;

        // if there is no path
        if (allPaths.isEmpty()) {
            return null;
        }
        bestPath = allPaths.get(0);

        for (int i = 1; i < allPaths.size(); i++) {

            currentPath = allPaths.get(i);
            // assign new best path
            if (currentPath.size() < bestPath.size()) {
                bestPath = currentPath;
            }

        }
        return bestPath;
    }

}


