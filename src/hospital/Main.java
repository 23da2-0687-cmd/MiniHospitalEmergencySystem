package hospital;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static BST patientTree = new BST();
    static EmergencyQueue emergencyQueue = new EmergencyQueue(20);
    static TreatmentStack treatmentStack = new TreatmentStack(20);
    static VisitHistory visitHistory = new VisitHistory();

    public static void main(String[] args) {

        int choice;

        do {
            displayMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    registerPatient();
                    break;

                case 2:
                    searchPatient();
                    break;

                case 3:
                    deletePatient();
                    break;

                case 4:
                    displayPatients();
                    break;

                case 5:
                    addEmergencyPatient();
                    break;

                case 6:
                    treatEmergencyPatient();
                    break;

                case 7:
                    displayEmergencyQueue();
                    break;

                case 8:
                    addTreatment();
                    break;

                case 9:
                    removeTreatment();
                    break;

                case 10:
                    displayTreatmentHistory();
                    break;

                case 11:
                    addPatientVisit();
                    break;

                case 12:
                    removePatientVisit();
                    break;

                case 13:
                    searchPatientVisit();
                    break;

                case 14:
                    displayVisitHistory();
                    break;

                case 0:
                    System.out.println("\nThank you for using the Hospital Management System.");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    
    // MAIN MENU
   

    public static void displayMenu() {

        System.out.println("\n==============================================");
        System.out.println("   MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM");
        System.out.println("==============================================");
        System.out.println("1.  Register Patient");
        System.out.println("2.  Search Patient");
        System.out.println("3.  Delete Patient");
        System.out.println("4.  Display All Patients");
        System.out.println("----------------------------------------------");
        System.out.println("5.  Add Emergency Patient");
        System.out.println("6.  Treat Emergency Patient");
        System.out.println("7.  Display Emergency Queue");
        System.out.println("----------------------------------------------");
        System.out.println("8.  Add Treatment");
        System.out.println("9.  Remove Treatment");
        System.out.println("10. Display Treatment History");
        System.out.println("----------------------------------------------");
        System.out.println("11. Add Patient Visit");
        System.out.println("12. Remove Patient Visit");
        System.out.println("13. Search Patient Visit");
        System.out.println("14. Display Visit History");
        System.out.println("----------------------------------------------");
        System.out.println("0.  Exit");
        System.out.println("==============================================");
    }

    
    // PATIENT BST OPERATIONS
    

    public static void registerPatient() {

        System.out.println("\n========== REGISTER PATIENT ==========");

        int patientId = readInt("Enter Patient ID: ");

        if (patientTree.search(patientId) != null) {
            System.out.println("Patient ID already exists.");
            return;
        }

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        int age = readInt("Enter Age: ");

        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();

        System.out.print("Enter Medical Condition: ");
        String condition = scanner.nextLine();

        Patient patient = new Patient(
                patientId,
                name,
                age,
                contact,
                condition
        );

        patientTree.insert(patient);

        System.out.println("Patient registered successfully.");
    }

    public static void searchPatient() {

        System.out.println("\n========== SEARCH PATIENT ==========");

        int patientId = readInt("Enter Patient ID: ");

        Patient patient = patientTree.search(patientId);

        if (patient != null) {

            System.out.println("\nPatient Found");
            System.out.println("----------------------");
            patient.display();

        } else {

            System.out.println("Patient not found.");
        }
    }

    public static void deletePatient() {

        System.out.println("\n========== DELETE PATIENT ==========");

        int patientId = readInt("Enter Patient ID: ");

        Patient patient = patientTree.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");
            return;
        }

        patientTree.delete(patientId);

        System.out.println("Patient deleted successfully.");
    }

    public static void displayPatients() {

        System.out.println("\n========== ALL PATIENTS ==========");

        patientTree.displayInOrder();
    }

    
    // EMERGENCY QUEUE OPERATIONS
    

    public static void addEmergencyPatient() {

        System.out.println("\n========== ADD EMERGENCY PATIENT ==========");

        int patientId = readInt("Enter Patient ID: ");

        Patient patient = patientTree.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");
            System.out.println("Please register the patient first.");

            return;
        }

        emergencyQueue.enqueue(patient);
    }

    public static void treatEmergencyPatient() {

        System.out.println("\n========== TREAT EMERGENCY PATIENT ==========");

        Patient patient = emergencyQueue.dequeue();

        if (patient == null) {
            return;
        }

        System.out.println("\nTreating Patient:");
        System.out.println("----------------------");

        patient.display();

        System.out.println("\nPatient treatment started.");
    }

    public static void displayEmergencyQueue() {

        System.out.println("\n========== EMERGENCY QUEUE ==========");

        emergencyQueue.display();
    }

    
    // TREATMENT STACK OPERATIONS
   

    public static void addTreatment() {

        System.out.println("\n========== ADD TREATMENT ==========");

        int patientId = readInt("Enter Patient ID: ");

        Patient patient = patientTree.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Treatment Description: ");
        String treatment = scanner.nextLine();

        String treatmentRecord =
                "Patient ID: " + patientId +
                " | Patient: " + patient.getPatientName() +
                " | Treatment: " + treatment;

        treatmentStack.push(treatmentRecord);
    }

    public static void removeTreatment() {

        System.out.println("\n========== REMOVE TREATMENT ==========");

        String treatment = treatmentStack.pop();

        if (treatment != null) {

            System.out.println("Removed Treatment:");
            System.out.println(treatment);
        }
    }

    public static void displayTreatmentHistory() {

        System.out.println("\n========== TREATMENT HISTORY ==========");

        treatmentStack.display();
    }

    
    // PATIENT VISIT OPERATIONS
    

    public static void addPatientVisit() {

        System.out.println("\n========== ADD PATIENT VISIT ==========");

        int patientId = readInt("Enter Patient ID: ");

        Patient patient = patientTree.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");
            return;
        }

        int visitId = readInt("Enter Visit ID: ");

        System.out.print("Enter Visit Date: ");
        String visitDate = scanner.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctorName = scanner.nextLine();

        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        Visit visit = new Visit(
                visitId,
                visitDate,
                doctorName,
                diagnosis,
                treatment
        );

        visitHistory.addVisit(visit);

        System.out.println("Patient visit added successfully.");
    }

    public static void removePatientVisit() {

        System.out.println("\n========== REMOVE PATIENT VISIT ==========");

        int visitId = readInt("Enter Visit ID: ");

        boolean removed = visitHistory.removeVisit(visitId);

        if (removed) {

            System.out.println("Visit removed successfully.");

        } else {

            System.out.println("Visit not found.");
        }
    }

    public static void searchPatientVisit() {

        System.out.println("\n========== SEARCH PATIENT VISIT ==========");

        int visitId = readInt("Enter Visit ID: ");

        Visit visit = visitHistory.searchVisit(visitId);

        if (visit != null) {

            System.out.println("\nVisit Found");
            System.out.println("----------------------");

            visit.display();

        } else {

            System.out.println("Visit not found.");
        }
    }

    public static void displayVisitHistory() {

        System.out.println("\n========== PATIENT VISIT HISTORY ==========");

        visitHistory.displayHistory();
    }

    
    // INPUT VALIDATION
    

    public static int readInt(String message) {

        while (true) {

            System.out.print(message);

            if (scanner.hasNextInt()) {

                int value = scanner.nextInt();
                scanner.nextLine();

                return value;

            } else {

                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }
}