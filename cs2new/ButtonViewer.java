import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This program demonstrates how to install an action listener.
 */

public class ButtonViewer {

    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 200;

    public static void main(String[] args) {

        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        // create two buttons - thats why you have to work with the panel
        JButton button = new JButton("Click me!");
        panel.add(button);

        JButton button2 = new JButton("Click me more often than the other button!");
        panel.add(button2);
        frame.add(panel);


        // calls the method, that will count the amount of clicks and that this will be printed
        ActionListener listener = new ClickListener();
        button.addActionListener(listener);

        ActionListener listener2 = new ClickListener();
        button2.addActionListener(listener2);


        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


}