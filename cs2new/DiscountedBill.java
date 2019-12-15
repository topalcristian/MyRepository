public class DiscountedBill extends Bill {

    private double discount;

    // constructor which takes the patient and doctor from the abstract class Bill and the discount
    public DiscountedBill(Patient patient, Doctor doc, double discount){
        super(patient, doc);
        this.discount = discount;
    }
    // overriden cost method takes number of appointments and return this number times the fee times the discount
    public double cost(double number_of_appointments){

        return (number_of_appointments*getDoctor().getOffice_Visit_Fee())*discount;
    }
}
