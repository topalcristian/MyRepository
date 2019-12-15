import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;


public class HouseComponent extends JComponent{



        public void paintComponent(Graphics g)
        {

            Graphics2D g2 = (Graphics2D)g;
            // creating house with given x, and y values
            House house = new House(100, 100);
            house.draw(g2);
        }


}
