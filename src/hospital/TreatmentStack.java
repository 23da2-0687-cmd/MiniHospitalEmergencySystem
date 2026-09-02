package hospital;

public class TreatmentStack {

    private String[] stack;
    private int top;

    public TreatmentStack(int capacity) {
        stack = new String[capacity];
        top = -1;
    }
}