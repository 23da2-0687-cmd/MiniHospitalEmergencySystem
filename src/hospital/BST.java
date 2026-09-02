package hospital;

public class BST {

    // Node class
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

    // =========================
    // INSERT PATIENT
    // =========================

    public void insert(Patient patient) {

        if (root == null) {
            root = new Node(patient);
            return;
        }

        insertRecursive(root, patient);
    }

    private void insertRecursive(Node current, Patient patient) {

        if (patient.getPatientId() < current.patient.getPatientId()) {

            if (current.left == null) {
                current.left = new Node(patient);
            } else {
                insertRecursive(current.left, patient);
            }

        } else if (patient.getPatientId() > current.patient.getPatientId()) {

            if (current.right == null) {
                current.right = new Node(patient);
            } else {
                insertRecursive(current.right, patient);
            }

        } else {

            System.out.println("Patient ID already exists.");
        }
    }

    // =========================
    // SEARCH PATIENT
    // =========================

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

    // =========================
    // DELETE PATIENT
    // =========================

    public void delete(int patientId) {

        root = deleteRecursive(root, patientId);
    }

    private Node deleteRecursive(Node current, int patientId) {

        if (current == null) {
            return null;
        }

        if (patientId < current.patient.getPatientId()) {

            current.left = deleteRecursive(
                    current.left,
                    patientId
            );

        } else if (patientId > current.patient.getPatientId()) {

            current.right = deleteRecursive(
                    current.right,
                    patientId
            );

        } else {

            // No left child
            if (current.left == null) {
                return current.right;
            }

            // No right child
            if (current.right == null) {
                return current.left;
            }

            // Two children
            Node successor = findMinimum(current.right);

            current.patient = successor.patient;

            current.right = deleteRecursive(
                    current.right,
                    successor.patient.getPatientId()
            );
        }

        return current;
    }

    // =========================
    // FIND MINIMUM
    // =========================

    private Node findMinimum(Node current) {

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // =========================
    // DISPLAY ALL PATIENTS
    // IN-ORDER TRAVERSAL
    // =========================

    public void displayInOrder() {

        if (root == null) {
            System.out.println("No patients registered.");
            return;
        }

        System.out.println("\n===== PATIENT RECORDS =====");

        inOrder(root);
    }

    private void inOrder(Node current) {

        if (current == null) {
            return;
        }

        // Left
        inOrder(current.left);

        // Root
        current.patient.display();

        System.out.println("----------------------------");

        // Right
        inOrder(current.right);
    }
}