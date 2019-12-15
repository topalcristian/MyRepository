// strategy pattern
public class CarTest{


    public static void main(String[] args) {

        class AddedFuelMeasurer implements Measurer {
            // I was not sure what to measure since it was not specified in the question,
            // thats why I measure the amonut of added fuel
            public double measure(Object anObject) {
                Car aCar = (Car) anObject;
                return aCar.getNewGas();
            }
        }
        class CarFilter implements Filter{
            public boolean accept(Object x)
            {
                Car aCar = (Car) x;
                // only cars with a motor number in the range from 500-1000 are accepted
                return aCar.getMotorNumber() < 1000 && aCar.getMotorNumber() > 500 ;
            }
        }

        Measurer m = new AddedFuelMeasurer();
        Filter f = new CarFilter();
        DataSet data = new DataSet(m, f);
        Car myCar1 = new Car(0.5, 300);
        Car myCar2 = new Car(0.7, 700);
        Car myCar3 = new Car(0.2, 1000);
        Car myCar4 = new Car(0.2, 501);

        myCar1.addGas(40);
        myCar2.addGas(50);
        myCar3.addGas(100);
        myCar4.addGas(150);

        data.add(myCar1);
        data.add(myCar2);
        data.add(myCar3);
        data.add(myCar4);

        System.out.println("Average added fuel = " + data.getAverage());
        Car max = (Car)data.getMaximum();
        System.out.println(" Car with maximum amount of added fuel= " + max);

    }
}
