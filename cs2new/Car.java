/*
Note that there is some code parts from the first lab, which are not necassary for this lab
*/
public class Car {

        private double amountFuel;
        private double fuel_efficiency;
        private int motor_no;
        static int counter = 0;
        private static String addedFuel = "";
        // variable which describes the amount of added fuel
        private double newGas;

        public Car(double fuel_efficiency, int motorNumber){
            // gas tank should be empty
            amountFuel = 0;
            this.fuel_efficiency = fuel_efficiency;
            counter++;
            motor_no = motorNumber;
        }
        // get current amount of fuel
        public double getGasInTank(){
            return amountFuel;
        }


        public void drive(double distance){
            // reducing fuel by the efficiency times the driven distance
            amountFuel = amountFuel - (fuel_efficiency*distance);
        }

        public void addGas(double newGas){



            String line = "Car Motor Number " +  this.motor_no + " added fuel: ";

            line = line + newGas + " liters \n";

            addedFuel = addedFuel + line;

            // adds new fuel to the tank
            amountFuel  = amountFuel + newGas;

            this.newGas = newGas;
        }
        // access the string object 
        public String getAddedFuel() { return addedFuel; }

        public int getMotorNumber(){ return motor_no; }

        public double getNewGas(){ return newGas; }

        public String toString(){ return "Car with motor number: " + motor_no; }


}
