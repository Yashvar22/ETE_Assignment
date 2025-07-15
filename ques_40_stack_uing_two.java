import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ques_40_stack_uing_two {
   Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty())
            q2.add(q1.poll());
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
       Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        System.out.println("Top: " + stack.peek());   // Output: 2
        System.out.println("Pop: " + stack.pop());   // Output: 2
        System.out.println("Empty: " + stack.empty()); // Output: false
    }
}
