import java.util.Stack;

public class StackUse {
    public static void main(String[] args) throws StackEmptyException, StackFullException {
        // StackUsingArray s = new StackUsingArray();
        Stack<Integer> s = new Stack<>();
        for (int i = 1; i <= 10; i++) {
            s.push(i);
        }
        System.out.println(s.size());
        System.out.println(s.isEmpty());

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

        // // System.out.println(s.pop());
        // // System.out.println(s.pop());
        // // System.out.println(s.peek());
        // // s.printStack();
        // // System.out.println(s.size());
        // // System.out.println(s.isEmpty());

        // while (!s.isEmpty()) {
        // System.out.println(s.pop());
        // }
    }
}
