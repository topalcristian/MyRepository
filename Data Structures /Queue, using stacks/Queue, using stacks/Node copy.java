public class Node<T>
{
    private T data;
     Node<T> next;

    Node(T d)  {
        data = d;
        next = null; }

    public void setNext(Node next) {

     this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getElement() {
    	return data;
    }

    public String toString(){

        String s = " " + getElement();

        return s;
    }
}