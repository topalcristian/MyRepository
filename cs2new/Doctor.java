// I do not write accessor and mutator methods from the two instance fields from person,
// since that would duplicate code and they are already inherited
public class Doctor extends Person {

    // instance fields
    private String speciality;
    private double office_visit_fee;

    // constructor
    public Doctor(String name, int age, String speciality, double office_visit_fee){
        super(name, age);
        this.speciality = speciality;
        this.office_visit_fee = office_visit_fee;
    }

    // accessor methods
    public String getSpecialitiy(){ return speciality; }

    public double getOffice_Visit_Fee(){ return office_visit_fee; }


    // mutator methods
    public void setSpeciality(String speciality){
        this.speciality = speciality;
    }

    public void setOffice_Visit_Fee(double office_visit_fee){
        this.office_visit_fee = office_visit_fee;
    }


    // overriden toString method
    public String toString(){
        return "[Name: " + super.getName() + "], [Age: " + super.getAge() + "], [Speciality: " + speciality + "], [Office visit fee: " + office_visit_fee + "]";
    }


    // overridden equals method
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }
        // casting the Object to Person in order to compare it
        Doctor doc = (Doctor) obj;
        return super.equals(doc) && speciality.equals(doc.speciality) && office_visit_fee == doc.office_visit_fee;
    }
}

