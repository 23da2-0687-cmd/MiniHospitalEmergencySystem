package hospital;

public class EmergencyQueue {

    private Patient[] queue;
    private int front;
    private int rear;
    private int size;

    public EmergencyQueue(int capacity) {
        queue = new Patient[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
}