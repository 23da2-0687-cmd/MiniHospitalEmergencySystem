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
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public void enqueue(Patient patient) {

        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = patient;
        size++;

        System.out.println("Patient added to emergency queue.");
    }

    public Patient dequeue() {

        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }

        Patient patient = queue[front];
        queue[front] = null;

        front = (front + 1) % queue.length;
        size--;

        return patient;
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return;
        }

        System.out.println("\nEmergency Patient Queue:");

        for (int i = 0; i < size; i++) {

            int index = (front + i) % queue.length;

            System.out.println("----------------------");
            queue[index].display();
        }
    }
}