public class Queue<T>{

    private Stack stack1;
    private Stack stack2;


    public Queue(){
        // enqueing stack
        stack1 = new Stack<T>();
        // dequeing stack
        stack2 = new Stack<T>();
    }
    // push data in stack one
    public void enqueue(T data ){

        Node<T> node = new Node<>(data);
        stack1.push(node);
    }

    public T dequeue(){

        while(!stack1.isEmpty()) {

            // pop data from stack one and push it into stack two until stack one is empty
            stack2.push(stack1.pop());

        }
        // pop one node from stack two
        Node<T> n = stack2.pop();
        T value = n.getElement();

        while(!stack2.isEmpty()){
            // pop updated data back to stack one
            stack1.push(stack2.pop());

        }
        return value;
    }
}