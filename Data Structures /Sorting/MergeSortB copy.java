import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;


public class MergeSortB{

        CompareClass comparing = new CompareClass();

        private ArrayList<Integer> alist;


        public MergeSortB(ArrayList<Integer> userList) {

            alist = userList;

        }

        public static void main(String[] args){


            ArrayList<Integer> userList = new ArrayList<Integer>();

            //random generator
            for (int i = 0; i < 100; i++) {
                int random = (int) (Math.random() * 99) + 1;
                userList.add(random);
            }


            // StopWatch timer = new StopWatch();
            MergeSortB mergesort = new MergeSortB(userList);
            mergesort.sort(userList);
            System.out.println("Sorted Array: " + mergesort.sort(userList));
            // System.out.println(timer.elapsed()+ " Seconds");
        }

        public ArrayList<Integer> merge(ArrayList<Integer> leftSide, ArrayList<Integer> rightSide) {

            ArrayList<Integer> newList = new ArrayList<Integer>();

            int i = 0;
            int j = 0;
            int k = 0;

            int n1 = leftSide.size();
            int n2 = leftSide.size();
            for(int p=0; p<n1+n2; p++){
                newList.add(0);

            }
            // sorted arrays merged to single one
            while (i < n1 && j < n2) {
                // using the comparator
                if ((comparing.compare(leftSide.get(i) , rightSide.get(j)))==0){
                    newList.set(k++, leftSide.get(i++));
                }else {
                    newList.set(k++, rightSide.get(j++));
                }
            }
            //  if elements are left then add to merged array
            while (i < n1)
                newList.set(k++, leftSide.get(i++));
            while (j < n2)
                newList.set(k++, rightSide.get(j++));

            return newList;
        }

        public ArrayList<Integer> sort(ArrayList<Integer> alist) {

            ArrayList<Integer> leftSide = new ArrayList<Integer>();
            ArrayList<Integer> rightSide = new ArrayList<Integer>();
            ArrayList<Integer> a1;
            // if less than 20 bubblesort
            if (alist.size() < 20) {
                BubbleSort(alist);
                return alist;
            } else {

                int middle = alist.size() / 2;
                //override left side
                for (int i = 0; i < middle; i++) {
                    leftSide.add(alist.get(i));
                }
                // override right side
                for (int i = middle; i < alist.size(); i++) {
                    rightSide.add(alist.get(i));
                }
                // sort left and right side -  recursive call
                leftSide = sort(leftSide);
                rightSide = sort(rightSide);

                ArrayList<Integer> hello = merge(leftSide, rightSide);
                 a1 = merge(rightSide, hello);

            }
            return a1;
        }


        //bubble sort
        public void BubbleSort(ArrayList<Integer> alist){
            int temp=0;
            for(int i = 0; i < alist.size(); i++){
             for(int j = 1; j < (alist.size()-i); j++){
                if(alist.get(j-1) > alist.get(j)){
                    temp = alist.get(j-1);
                    alist.set((j-1), alist.get(j));
                    alist.set(j, temp);
                }
             }
            }
    }
}