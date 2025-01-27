import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push Operation
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Peek Operation
        System.out.println("Top element: " + stack.peek()); // Should print 30

        // Pop Operation
        System.out.println("Popped element: " + stack.pop()); // Should print 30

        // Check if Stack is Empty
        System.out.println("Is stack empty? " + stack.isEmpty());

        // Display current elements in stack
        System.out.println("Current Stack: " + stack);

        // Pop all elements
        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }

        System.out.println("Stack after popping all elements: " + stack);
    }
}
