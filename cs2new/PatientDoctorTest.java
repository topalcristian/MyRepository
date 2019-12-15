public class PatientDoctorTest {

    public static void main(String[] args){

        Patient patient1 = new Patient("Consti", 21, "AB123");
        Patient patient2 = new Patient("Chrissi", 20, "BB123");
        Patient patient3 = new Patient("Alex", 19, "CB123");
        System.out.println(patient1); // just to test the toString method

        Doctor doc1 = new Doctor("Jasper", 19, "Pediatrician", 25.0);
        Doctor doc2 = new Doctor("John", 20, " Obstetrician", 30.0);
        Doctor doc3 = new Doctor("Carl", 19, "Dentist", 20.0);
        System.out.println(doc1); // just to test the toString method

        Bill bill1 = new DiscountedBill(patient1, doc1, 0.9);
        Bill bill2 = new DiscountedBill(patient2, doc2, 0.5);
        Bill bill3 = new DiscountedBill(patient3, doc3, 0.6);

        System.out.println("The patient " + patient1.getName() + " has to pay " + bill1.cost(5) + " Euros to " + doc1.getName());
        System.out.println("The patient " + patient2.getName() + " has to pay " + bill2.cost(50) + " Euros to " + doc2.getName());
        System.out.println("The patient " + patient3.getName() + " has to pay " + bill3.cost(10) + " Euros to " + doc3.getName());

    }
}
