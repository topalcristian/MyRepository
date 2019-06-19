import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;


public class MergeSortA {

    CompareClass comparing = new CompareClass();

    private ArrayList<Integer> alist;


    public MergeSortA(ArrayList<Integer> userList) {

        alist = userList;

    }

    public static void main(String[] args) {


        ArrayList<Integer> userList = new ArrayList<Integer>();
        // random number generator
        for (int i = 0; i < 100; i++) {
            int random = (int) (Math.random() * 99) + 1;
            userList.add(random);
        }

        // StopWatch timer = new StopWatch();
        MergeSortA mergesort = new MergeSortA(userList);
        System.out.println("The sorted Array: " + mergesort.sort(userList));
        //  System.out.println(timer.elapsed()+ " Seconds");
    }

    public ArrayList<Integer> merge(ArrayList<Integer> leftSide, ArrayList<Integer> rightSide) {

        ArrayList<Integer> llist = new ArrayList<Integer>();

        int i_ = 0;
        int j_ = 0;
        int k_ = 0;

        // rightside size = leftside size
        int n1_ = leftSide.size();
        int n2_ = leftSide.size();
        for (int p = 0; p < n1_ + n2_; p++) {
            llist.add(0);

        }
        // sorted arrays merged to single one
        while (i_ < n1_ && j_ < n2_) {
            // using comparator
            // if rightside is greater or equal to leftside
            if ((comparing.compare(leftSide.get(i_), rightSide.get(j_))) == 0) {
                llist.set(k_++, leftSide.get(i_++));
                // if leftside is greater than rightside
            } else {
                llist.set(k_++, rightSide.get(j_++));
            }
        }
        //  if elements are left then add to merged array
        while (i_ < n1_)
            llist.set(k_++, leftSide.get(i_++));
        while (j_ < n2_)
            llist.set(k_++, rightSide.get(j_++));

        return llist;

    }

    public ArrayList<Integer> sort(ArrayList<Integer> alist) {

        ArrayList<Integer> leftSide = new ArrayList<Integer>();
        ArrayList<Integer> rightSide = new ArrayList<Integer>();

        // base case
        if (alist.size() == 1) {
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
            // sort left and right side recursively
            leftSide = sort(leftSide);
            rightSide = sort(rightSide);


        }
        return merge(leftSide, rightSide);
    }

}