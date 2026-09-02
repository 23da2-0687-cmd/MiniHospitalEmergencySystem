package hospital;

public class Visit {

    int visitId;
    String visitDate;
    String doctorName;
    String diagnosis;
    String treatment;
    Visit next;

    public Visit(int visitId, String visitDate, String doctorName,
            String diagnosis, String treatment) {

   this.visitId = visitId;
   this.visitDate = visitDate;
   this.doctorName = doctorName;
   this.diagnosis = diagnosis;
   this.treatment = treatment;
   this.next = null;
}

public void display() {

   System.out.println("Visit ID: " + visitId);
   System.out.println("Visit Date: " + visitDate);
   System.out.println("Doctor: " + doctorName);
   System.out.println("Diagnosis: " + diagnosis);
   System.out.println("Treatment: " + treatment);
}

}