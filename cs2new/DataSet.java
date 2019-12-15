public class DataSet {

    private double sum;
    private Object maximum;
    private int count;
    private Measurer measurer;
    private Filter filter;

    public DataSet(Measurer aMeasurer, Filter aFilter) {
        sum = 0;
        count = 0;
        maximum = null;
        measurer = aMeasurer;
        filter = aFilter;
    }

    public void add(Object x) {
        if (filter.accept(x)) {
            sum = sum + measurer.measure(x);
            if (count == 0
                    || measurer.measure(maximum) < measurer.measure(x))
                maximum = x;
            count++;
        }
    }

    public double getAverage() {
        if (count == 0) {
            return 0;
        }
        else{
            return sum / count;
        }
    }

    public Object getMaximum() {
        return maximum;
    }
}

