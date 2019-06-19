public class Vertex<T> {
    final private T id;
    private boolean isVisit;


    public Vertex(T id) {
        this.id = id;

    }
    // returns true if vertex is visited
    public boolean isVisit() {
        return isVisit;
    }

    public void setVisit(boolean isVisit) {
        this.isVisit = isVisit;
    }

    public T getId() {
        return id;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public String toString() {
        return id.toString();
    }
}