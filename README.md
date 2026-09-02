# Mini Hospital Emergency Management System

A console-based Java application that simulates core hospital operations — patient registration, emergency triage, treatment logging, and visit history tracking — built to demonstrate fundamental data structures (BST, Queue, Stack, and Linked List) in a real-world scenario.

## Features

- **Patient Records (Binary Search Tree)**
  - Register a new patient with ID, name, age, contact number, and medical condition
  - Search for a patient by ID
  - Delete a patient record
  - Display all patients in sorted (in-order) order

- **Emergency Queue (Circular Array Queue — FIFO)**
  - Add a registered patient to the emergency queue
  - Treat (dequeue) the next patient in line
  - Display the current emergency queue

- **Treatment History (Array-based Stack — LIFO)**
  - Add a treatment record for a patient
  - Remove (pop) the most recent treatment
  - Display full treatment history, most recent first

- **Patient Visit History (Singly Linked List)**
  - Add a visit record (visit ID, date, doctor, diagnosis, treatment)
  - Remove a visit by ID
  - Search for a visit by ID
  - Display the full visit history

All operations are exposed through a numbered, menu-driven console interface.

## Project Structure

```
MiniHospitalEmergencySystem/
├── src/
│   ├── module-info.java
│   └── hospital/
│       ├── Main.java            # Entry point; menu-driven console UI
│       ├── Patient.java         # Patient data model
│       ├── BST.java             # Binary Search Tree for patient records
│       ├── EmergencyQueue.java  # Circular array queue for emergency triage
│       ├── TreatmentStack.java  # Array-based stack for treatment history
│       ├── Visit.java           # Visit record / linked list node
│       ├── VisitHistory.java    # Singly linked list of patient visits
│       └── Test.java            # Standalone test/demo harness
├── bin/                         # Compiled .class files (Eclipse output)
├── .project / .classpath        # Eclipse project configuration
└── .git/                        # Git repository
```

## Requirements

- Java Development Kit (JDK) 9 or later (project uses a Java module, `module-info.java`)
- Any Java IDE (Eclipse recommended — project already includes `.project`/`.classpath`) or a plain terminal with `javac`/`java`

## How to Run

### Option 1: Eclipse (or another Java IDE)
1. Import the project as an existing Eclipse project (`File > Import > Existing Projects into Workspace`).
2. Open `src/hospital/Main.java`.
3. Run it as a Java Application.

### Option 2: Command Line
From the project root:

```bash
# Compile
javac -d bin src/module-info.java src/hospital/*.java

# Run
java -cp bin hospital.Main
```

## Usage

On launch, you'll see a main menu:

```
==============================================
   MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM
==============================================
1.  Register Patient
2.  Search Patient
3.  Delete Patient
4.  Display All Patients
----------------------------------------------
5.  Add Emergency Patient
6.  Treat Emergency Patient
7.  Display Emergency Queue
----------------------------------------------
8.  Add Treatment
9.  Remove Treatment
10. Display Treatment History
----------------------------------------------
11. Add Patient Visit
12. Remove Patient Visit
13. Search Patient Visit
14. Display Visit History
----------------------------------------------
0.  Exit
==============================================
```

Enter a number to perform the corresponding action, then follow the on-screen prompts. A typical workflow is:

1. **Register Patient** (option 1) — create a patient record first.
2. **Add Emergency Patient** (option 5) — place a registered patient into the emergency queue.
3. **Treat Emergency Patient** (option 6) — process patients in FIFO order.
4. **Add Treatment** (option 8) — log treatments for a patient (most recent shown first).
5. **Add Patient Visit** (option 11) — record a full visit (date, doctor, diagnosis, treatment) for long-term history.

## Data Structures Used

| Structure    | Class              | Purpose                                              |
|--------------|--------------------|-------------------------------------------------------|
| Binary Search Tree | `BST.java`   | Fast insert/search/delete of patients by ID, sorted display |
| Queue (circular array) | `EmergencyQueue.java` | First-come-first-served emergency triage |
| Stack (array)  | `TreatmentStack.java` | Most-recent-first treatment history |
| Linked List    | `VisitHistory.java` / `Visit.java` | Ordered, dynamically-growing visit records |

## Notes

- `Test.java` contains a standalone demo/test harness with sample patients and visits. Note that it references classes (`Queue`, `Stack`, `VisitLinkedList`, and a `bst.inOrderTraversal()` method) that don't match the current names in this codebase (`EmergencyQueue`, `TreatmentStack`, `VisitHistory`, and `displayInOrder()`), so it will need those references updated before it will compile and run alongside `Main.java`.
- The `bin/` folder contains precompiled `.class` files from Eclipse's build; you can delete it and rebuild if you prefer a clean build.
- This project is designed as an educational example (e.g., for a data structures course) rather than a production hospital system — it has no persistent storage, so all data resets when the program exits.

