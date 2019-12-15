import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class AnalyzeFile {

    public static void main(String[] args) {

        // count chars
        int chars = 0;
        // count words
        int words = 0;
        // count lines
        int lines = 0;

        Scanner in = null;
        try {
            in = new Scanner(System.in);
            System.out.println("What is the name of your file?");
            // reads from the terminal the filename
            String fileName = in.next();
            File file = new File(fileName);
            // Scan through file
            Scanner scanLines = new Scanner(file);
            // every line gets count
            while (scanLines.hasNextLine()) {
                // increase variable lines
                lines++;
                scanLines.nextLine();
            }
            Scanner scanWords = new Scanner(file);
            // then every word
            while (scanWords.hasNext()) {
                // increase variable words
                words++;
                String word = scanWords.next();
                // and the amount of chars can be determined if you know the length of every word
                chars = chars + word.length();
            }

            // Exception, if the file name that the user gave as input in the terminal can not be found
        } catch (FileNotFoundException h) {
            h.printStackTrace();
            System.out.println("Attention! Enter the right file name!");


        } finally {
            // close scanner and print everything
            if (in != null) in.close();
        }
        System.out.println("The amount of lines: " + lines);
        System.out.println("The amount of words: " + words);
        System.out.println("The amount of chars: " + chars);

    }
}