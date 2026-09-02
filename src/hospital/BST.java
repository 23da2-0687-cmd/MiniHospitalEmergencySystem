package hospital;

public class BST {

    private class Node {
        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {
            this.patient = patient;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    // Insert patient
    public void insert(Patient patient) {
        root = insertRecursive(root, patient);
    }

    private Node insertRecursive(Node current, Patient patient) {

        if (current == null) {
            return new Node(patient);
        }

        if (patient.getPatientId() < current.patient.getPatientId()) {

            current.left = insertRecursive(current.left, patient);

        } else if (patient.getPatientId() > current.patient.getPatientId()) {

            current.right = insertRecursive(current.right, patient);

        }

        return current;
    }

    // Search patient
    public Patient search(int patientId) {

        Node current = root;

        while (current != null) {

            if (patientId == current.patient.getPatientId()) {
                return current.patient;
            }

            if (patientId < current.patient.getPatientId()) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    // Delete patient
    public void delete(int patientId) {
        root = deleteRecursive(root, patientId);
    }

    private Node deleteRecursive(Node current, int patientId) {

        if (current == null) {
            return null;
        }

        if (patientId < current.patient.getPatientId()) {

            current.left = deleteRecursive(current.left, patientId);

        } else if (patientId > current.patient.getPatientId()) {

            current.right = deleteRecursive(current.right, patientId);

        } else {

            // Case 1: No left child
            if (current.left == null) {
                return current.right;
            }

            // Case 2: No right child
            if (current.right == null) {
                return current.left;
            }

            // Case 3: Two children
            Node successor = findMinimum(current.right);

            current.patient = successor.patient;

            current.right = deleteRecursive(
                    current.right,
                    successor.patient.getPatientId()
            );
        }

        return current;
    }

    // Find smallest node
    private Node findMinimum(Node current) {

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // Display patients in sorted order
    public void displayInOrder() {
        inOrder(root);
    }

    private void inOrder(Node current) {

        if (current != null) {

            inOrder(current.left);

            current.patient.display();

            System.out.println("----------------------");

            inOrder(current.right);
        }
    }
}