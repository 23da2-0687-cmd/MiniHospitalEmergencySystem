package hospital;

public class VisitHistory {

    private Visit head;

    public void addVisit(Visit newVisit) {

        if (head == null) {
            head = newVisit;
            return;
        }

        Visit current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newVisit;
    }

    public boolean removeVisit(int visitId) {

        if (head == null) {
            return false;
        }

        if (head.visitId == visitId) {
            head = head.next;
            return true;
        }

        Visit current = head;

        while (current.next != null) {

            if (current.next.visitId == visitId) {
                current.next = current.next.next;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public Visit searchVisit(int visitId) {

        Visit current = head;

        while (current != null) {

            if (current.visitId == visitId) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    public void displayHistory() {

        if (head == null) {
            System.out.println("Visit history is empty.");
            return;
        }

        Visit current = head;

        while (current != null) {
            current.display();
            System.out.println("----------------------");
            current = current.next;
        }
    }
    
}