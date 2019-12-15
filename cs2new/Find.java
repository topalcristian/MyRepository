import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Find {

    public static void main (String[] args) throws FileNotFoundException {

        Scanner in;
        // index=0, since the reversed word is the first that gets read by args in the command line
        String input = args[0];
        // for loop that iterates through the line that is getting read by args - starts at 1, since index=0 the reversed is
        for(int i=1; i<args.length; i++){
            // goes through every file
            File file = new File(args[i]);
            // scanning files
            in = new Scanner(file);
            // go through every word/line
            while (in.hasNext()){
                String line = in.nextLine();
                // if a file contains the reserved word, the line gets printed
                if(line.contains(input)){
                    System.out.println(line);
                }

            }

        }
    }

}
