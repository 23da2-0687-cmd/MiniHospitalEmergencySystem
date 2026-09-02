package hospital;

public class BST {

    private class Node {
        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {
            this.patient = patient;
        }
    }

    private Node root;
}

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

        if (current.left == null) {
            return current.right;
        }

        if (current.right == null) {
            return current.left;
        }

        Node successor = findMinimum(current.right);
        current.patient = successor.patient;
        current.right = deleteRecursive(
                current.right,
                successor.patient.getPatientId()
        );
    }

    return current;
}

private Node findMinimum(Node current) {

    while (current.left != null) {
        current = current.left;
    }

    return current;
}

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