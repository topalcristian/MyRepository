public class StackExample{

    public static void main(String [] args){

        Queue<Integer> queue = new Queue<>();

        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.dequeue();
        queue.enqueue(9);
        queue.dequeue();
        queue.dequeue();

                System.out.println(queue.dequeue());
    }
}