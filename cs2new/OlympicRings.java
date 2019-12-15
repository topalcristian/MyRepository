import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;

public class OlympicRings {

    private double xLeft;
    private double yTop;


    public OlympicRings(double x, double y){

        xLeft = x;
        yTop = y;

    }

    public void draw(Graphics2D g2){

        // creating all the rings
        Ellipse2D.Double bluering = new Ellipse2D.Double(xLeft, yTop, 100, 100);
        Ellipse2D.Double blackring = new Ellipse2D.Double(xLeft + 100, yTop, 100, 100);
        Ellipse2D.Double redring = new Ellipse2D.Double(xLeft + 200, yTop, 100, 100);
        Ellipse2D.Double yellowring = new Ellipse2D.Double(xLeft + 50, yTop + 50, 100, 100);
        Ellipse2D.Double greenring = new Ellipse2D.Double(xLeft + 150, yTop + 50, 100, 100);

        // drawing with different colours (in the task there was asked for a thickness of the rings)
        g2.setColor(Color.BLUE);
        g2.draw(bluering);
        g2.setColor(Color.BLACK);
        g2.draw(blackring);
        g2.setColor(Color.RED);
        g2.draw(redring);
        g2.setColor(Color.YELLOW);
        g2.draw(yellowring);
        g2.setColor(Color.GREEN);
        g2.draw(greenring);


    }
}
