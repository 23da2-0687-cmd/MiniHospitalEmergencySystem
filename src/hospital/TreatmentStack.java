package hospital;

public class TreatmentStack {

    private String[] stack;
    private int top;

    public TreatmentStack(int capacity) {
        stack = new String[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }

    public void push(String treatment) {

        if (isFull()) {
            System.out.println("Treatment stack is full.");
            return;
        }

        stack[++top] = treatment;

        System.out.println("Treatment added.");
    }

    public String pop() {

        if (isEmpty()) {
            System.out.println("Treatment stack is empty.");
            return null;
        }

        return stack[top--];
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Treatment history is empty.");
            return;
        }

        System.out.println("\nTreatment History:");

        for (int i = top; i >= 0; i--) {
            System.out.println((top - i + 1) + ". " + stack[i]);
        }
    }
}