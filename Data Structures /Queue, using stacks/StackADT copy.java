public interface StackADT<T>{

         Node<T> pop();
         void push(Node<T> data);
         boolean isEmpty();
}