package hospital;

public class Test {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" HOSPITAL SYSTEM - TESTING");
        System.out.println("======================================");

        
        // 1. PATIENT CREATION TEST
       
        System.out.println("\n--- Patient Creation Test ---");

        Patient p1 = new Patient(
                101,
                "Ahmed",
                25,
                "0771234567",
                "Fever"
        );

        Patient p2 = new Patient(
                105,
                "Rizwan",
                30,
                "0777654321",
                "Flu"
        );

        Patient p3 = new Patient(
                99,
                "Hassan",
                40,
                "0712345678",
                "Headache"
        );

        System.out.println("Patient 1 created successfully.");
        System.out.println("Patient 2 created successfully.");
        System.out.println("Patient 3 created successfully.");

        
        // 2. BST TESTING
       

        System.out.println("\n======================================");
        System.out.println(" BST TESTING");
        System.out.println("======================================");

        BST bst = new BST();

        System.out.println("\nInserting patients...");

        bst.insert(p1);
        bst.insert(p2);
        bst.insert(p3);

        System.out.println("Patients inserted successfully.");

        // In-order traversal
        System.out.println("\nIn-order Traversal:");
        bst.displayInOrder();

        // Search existing patient
        System.out.println("\n--- BST Search Test ---");

        System.out.println("Searching Patient ID 105:");

        Patient found = bst.search(105);

        if (found != null) {
            System.out.println("Patient found successfully.");
            found.display();
        } else {
            System.out.println("Patient not found.");
        }

        // Search non-existing patient
        System.out.println("\nSearching Patient ID 500:");

        Patient notFound = bst.search(500);

        if (notFound == null) {
            System.out.println("Patient 500 not found - Test Passed.");
        } else {
            System.out.println("Test Failed.");
        }

        // Delete patient
        System.out.println("\n--- BST Delete Test ---");

        System.out.println("Deleting Patient ID 105:");

        bst.delete(105);

        System.out.println("BST after deletion:");
        bst.displayInOrder();

        // Verify deleted patient
        System.out.println("\nSearching deleted Patient ID 105:");

        Patient deletedPatient = bst.search(105);

        if (deletedPatient == null) {
            System.out.println("Patient 105 deleted successfully.");
        } else {
            System.out.println("Delete test failed.");
        }

        
        // 3. EMERGENCY QUEUE TESTING
        
        System.out.println("\n======================================");
        System.out.println(" EMERGENCY QUEUE TESTING");
        System.out.println("======================================");

        EmergencyQueue queue = new EmergencyQueue(5);

        System.out.println("\nAdding patients to emergency queue...");

        queue.enqueue(p1);
        queue.enqueue(p2);
        queue.enqueue(p3);

        System.out.println("Patients added successfully.");

        // Display queue
        System.out.println("\nCurrent Emergency Queue:");

        queue.display();

        // Check queue status
        System.out.println("\nQueue empty status: " + queue.isEmpty());
        System.out.println("Queue full status: " + queue.isFull());

        // Dequeue first patient
        System.out.println("\n--- Queue Dequeue Test ---");

        Patient nextPatient = queue.dequeue();

        if (nextPatient != null) {

            System.out.println("Dequeued patient successfully.");

            System.out.println(
                    "Dequeued Patient ID: "
                    + nextPatient.getPatientId()
            );

            if (nextPatient.getPatientId() == 101) {
                System.out.println("FIFO test passed.");
            } else {
                System.out.println("FIFO test failed.");
            }

        } else {
            System.out.println("Queue is empty.");
        }

        // Display queue after dequeue
        System.out.println("\nQueue after dequeue:");

        queue.display();

        
        // 4. EMPTY QUEUE TEST
        
        System.out.println("\n--- Empty Queue Test ---");

        queue.dequeue();
        queue.dequeue();

        Patient emptyPatient = queue.dequeue();

        if (emptyPatient == null) {
            System.out.println("Empty queue handled correctly.");
        } else {
            System.out.println("Empty queue test failed.");
        }

        System.out.println(
                "Queue empty status: "
                + queue.isEmpty()
        );

        
        // 5. TREATMENT STACK TESTING
        

        System.out.println("\n======================================");
        System.out.println(" TREATMENT STACK TESTING");
        System.out.println("======================================");

        TreatmentStack stack = new TreatmentStack(5);

        System.out.println("\nAdding treatment records...");

        stack.push("Treatment for Patient 101");
        stack.push("Treatment for Patient 105");
        stack.push("Treatment for Patient 99");

        System.out.println("Treatment records added successfully.");

        // Display stack
        System.out.println("\nCurrent Treatment History:");

        stack.display();

        // Check stack status
        System.out.println("\nStack empty status: " + stack.isEmpty());
        System.out.println("Stack full status: " + stack.isFull());

        // Pop test
        System.out.println("\n--- Stack Pop Test ---");

        String treatment = stack.pop();

        if (treatment != null) {

            System.out.println("Treatment removed successfully.");
            System.out.println("Removed: " + treatment);

            if (treatment.equals("Treatment for Patient 99")) {
                System.out.println("LIFO test passed.");
            } else {
                System.out.println("LIFO test failed.");
            }

        } else {
            System.out.println("Stack is empty.");
        }

        // Display stack after pop
        System.out.println("\nStack after pop:");

        stack.display();

        
        // 6. EMPTY STACK TEST
       

        System.out.println("\n--- Empty Stack Test ---");

        stack.pop();
        stack.pop();

        String emptyTreatment = stack.pop();

        if (emptyTreatment == null) {
            System.out.println("Empty stack handled correctly.");
        } else {
            System.out.println("Empty stack test failed.");
        }

        System.out.println(
                "Stack empty status: "
                + stack.isEmpty()
        );

       
        // 7. VISIT HISTORY LINKED LIST TESTING
        

        System.out.println("\n======================================");
        System.out.println(" VISIT HISTORY TESTING");
        System.out.println("======================================");

        VisitHistory visitHistory = new VisitHistory();

        Visit v1 = new Visit(
                1,
                "2026-09-01",
                "Dr. Ahmed",
                "Fever",
                "Medication"
        );

        Visit v2 = new Visit(
                2,
                "2026-09-02",
                "Dr. Rizwan",
                "Flu",
                "Rest and medication"
        );

        Visit v3 = new Visit(
                3,
                "2026-09-03",
                "Dr. Hassan",
                "Headache",
                "Pain relief"
        );

        // Add visits
        System.out.println("\nAdding patient visits...");

        visitHistory.addVisit(v1);
        visitHistory.addVisit(v2);
        visitHistory.addVisit(v3);

        System.out.println("Visits added successfully.");

        // Display visits
        System.out.println("\nPatient Visit History:");

        visitHistory.displayHistory();

        // ==========================================
        // 8. LINKED LIST SEARCH TEST
        // ==========================================

        System.out.println("\n--- Visit Search Test ---");

        System.out.println("Searching Visit ID 2:");

        Visit searchedVisit = visitHistory.searchVisit(2);

        if (searchedVisit != null) {

            System.out.println("Visit ID 2 found successfully.");

            searchedVisit.display();

        } else {

            System.out.println("Visit ID 2 not found.");

        }

        // Search non-existing visit
        System.out.println("\nSearching Visit ID 100:");

        Visit missingVisit = visitHistory.searchVisit(100);

        if (missingVisit == null) {
            System.out.println(
                    "Visit ID 100 not found - Test Passed."
            );
        } else {
            System.out.println("Search test failed.");
        }

        
        // 9. LINKED LIST REMOVE TEST
       

        System.out.println("\n--- Visit Remove Test ---");

        System.out.println("Removing Visit ID 2...");

        boolean removed = visitHistory.removeVisit(2);

        if (removed) {
            System.out.println("Visit ID 2 removed successfully.");
        } else {
            System.out.println("Visit removal failed.");
        }

        // Display after removal
        System.out.println("\nVisit History after removal:");

        visitHistory.displayHistory();

        // Verify removal
        System.out.println("\nSearching removed Visit ID 2:");

        Visit removedVisit = visitHistory.searchVisit(2);

        if (removedVisit == null) {
            System.out.println(
                    "Visit ID 2 no longer exists - Test Passed."
            );
        } else {
            System.out.println("Remove test failed.");
        }

       
        // 10. FINAL TEST RESULT
        

        System.out.println("\n======================================");
        System.out.println(" ALL TESTING COMPLETED");
        System.out.println("======================================");

        System.out.println("\nTested:");

        System.out.println("1. Patient creation");
        System.out.println("2. BST insertion");
        System.out.println("3. BST search");
        System.out.println("4. BST deletion");
        System.out.println("5. BST in-order traversal");

        System.out.println("6. Emergency Queue enqueue");
        System.out.println("7. Emergency Queue dequeue");
        System.out.println("8. FIFO behavior");
        System.out.println("9. Empty Queue handling");

        System.out.println("10. Treatment Stack push");
        System.out.println("11. Treatment Stack pop");
        System.out.println("12. LIFO behavior");
        System.out.println("13. Empty Stack handling");

        System.out.println("14. Visit History add");
        System.out.println("15. Visit History search");
        System.out.println("16. Visit History remove");
        System.out.println("17. Visit History display");

        System.out.println("\nTesting finished successfully.");
    }
}