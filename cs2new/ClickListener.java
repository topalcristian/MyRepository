import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * An action listener that prints a message.
 */
public class ClickListener implements ActionListener {

        int counter = 0;

    // get called, every time one of the buttons get clicked
    public void actionPerformed(ActionEvent event) {

        // every time button gets clicked, counter increases and the amount often clicks will be printed
        counter++;

        System.out.println("I was clicked: " +  counter +  " times");
    }
}