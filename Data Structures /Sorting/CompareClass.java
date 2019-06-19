import java.util.Comparator;

    public class CompareClass implements Comparator<Integer>{

        public int compare(Integer o1, Integer o2) {


            if(o1<=o2){
                return 0;
            }
            else
                return 1;
        }
    }