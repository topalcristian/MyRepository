public class Patient extends Person {

    //instance field
    private String identification_number;

    //constructor
    public Patient(String name, int age, String identification_number){
        super(name, age);
        this.identification_number = identification_number;
    }


    //accessor method
    public String getIdentification_Number(){ return identification_number; }

    //mutator method
    public void setIdentification_Number(){

        this.identification_number= identification_number;
    }

    //overridden toString method
    public String toString(){
        return "[Name: " + super.getName() + "], [Age: " + super.getAge() + "], [Identification Number: " + identification_number + "]";
    }

    //overriden equals method
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }
        // casting the Object to Person in order to compare it
        Patient patient = (Patient) obj;
        return super.equals(patient) && identification_number == patient.identification_number;
    }

}
