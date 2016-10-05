package stack;

import java.util.Stack;

public class QueueUsingStacks <T> {
	  Stack<T> stackNewestOnTop = new Stack<T>();
      Stack<T> stackOldestOnTop = new Stack<T>();

      public void enqueue(T value) { // Push onto newest stack
          stackNewestOnTop.push(value);          
      }

      public T peek() {
          if(stackOldestOnTop.isEmpty())
               populateStack();
          if(!stackOldestOnTop.isEmpty())
              return stackOldestOnTop.peek();
          return null;
      }

      public T dequeue() {
          if(stackOldestOnTop.isEmpty())
               populateStack();
          if(!stackOldestOnTop.isEmpty())
              return stackOldestOnTop.pop();
          return null;
      }
      
      private void populateStack(){
          while(!stackNewestOnTop.isEmpty()){
              stackOldestOnTop.push(stackNewestOnTop.pop());
          }
          
      }
      
      public static void main(String...strings){
    	  QueueUsingStacks<Integer> queue = new QueueUsingStacks<Integer>();
    	  queue.enqueue(2);
    	  queue.enqueue(4);
    	  System.out.println(queue.dequeue());
    	  System.out.println(queue.peek());
      }

}
