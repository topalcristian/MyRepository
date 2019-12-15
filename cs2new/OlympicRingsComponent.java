import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class OlympicRingsComponent extends JComponent {

    public void paintComponent(Graphics g){

        Graphics2D g2 = (Graphics2D)g;
        // creating rings with given x, and y values
        OlympicRings rings = new OlympicRings(100, 100);
        rings.draw(g2);
    }
}
