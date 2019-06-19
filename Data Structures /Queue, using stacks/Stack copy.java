public class Stack<T> implements StackADT<T>{

    Node<T> head;

    public Stack(){
        head = null;
    }

    // push data
    public void push(Node<T> data){


            data.setNext(head);
            head = data;
    }
    // pop data
     public Node<T> pop(){

        Node<T> prev = head;
        head = prev.getNext();
        return prev;

     }

    // checks if stack is empty
    public boolean isEmpty(){

        if(head == null){
            return true;
        }
        return false;
    }

}