public abstract class Bill {

    private Patient patient;
    private Doctor doc;

    // constructor
    public Bill(Patient patient, Doctor doc){
        this.patient = patient;
        this.doc = doc;
    }

    // cost method with a given number of appointments
    public double cost(double number_of_appointments){

        return number_of_appointments*doc.getOffice_Visit_Fee();
    }

    // accessor methods of private instance fields
    public Patient getPatient(){ return patient; }

    public Doctor getDoctor(){ return doc; }
}
