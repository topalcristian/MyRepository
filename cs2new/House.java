import sun.jvm.hotspot.types.PointerType;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;


public class House {

    private double xLeft;
    private double yTop;

    public House(double x, double y){
        xLeft = x;
        yTop = y;
    }

    public void draw(Graphics2D g2){
        // all rectangular shapes
        Rectangle2D.Double body = new Rectangle2D.Double(xLeft+100,yTop+225, 300, 175);
        Rectangle2D.Double roof = new Rectangle2D.Double(xLeft+25,yTop+175, 425, 50);
        Rectangle2D.Double door = new Rectangle2D.Double(xLeft+250,yTop+310, 75, 90);
        Rectangle2D.Double window = new Rectangle2D.Double(xLeft+150,yTop+250, 80, 40);
        Rectangle2D.Double window2 = new Rectangle2D.Double( xLeft+ 300, yTop+250, 80, 40);

        // points which will be connected
        Point2D.Double r1 = new Point2D.Double(xLeft+325, yTop+355);
        Point2D.Double r2 = new Point2D.Double(xLeft+400, yTop+400);
        Point2D.Double r3 = new Point2D.Double(xLeft+500, yTop+187.5);
        Point2D.Double r4 = new Point2D.Double(xLeft+500, yTop+325);
        Point2D.Double r5 = new Point2D.Double(xLeft+450, yTop+175);
        Point2D.Double r6 = new Point2D.Double(xLeft+450, yTop+225);
        Point2D.Double r7 = new Point2D.Double(xLeft+550, yTop+100);
        Point2D.Double r8 = new Point2D.Double(xLeft+550, yTop+150);
        Point2D.Double r9 = new Point2D.Double(xLeft+150, yTop+100);
        Point2D.Double r10 = new Point2D.Double(xLeft+25, yTop+175);
        Point2D.Double r11 = new Point2D.Double(xLeft+315, yTop+355);

        // lines connect points
        Line2D.Double wall2 = new Line2D.Double(r2,r4);
        Line2D.Double wall3 = new Line2D.Double(r5,r7);
        Line2D.Double wall4 = new Line2D.Double(r6,r8);
        Line2D.Double wall5 = new Line2D.Double(r3,r4);
        Line2D.Double wall7 = new Line2D.Double(r7,r8);
        Line2D.Double wall8 = new Line2D.Double(r7,r9);
        Line2D.Double wall9 = new Line2D.Double(r9, r10);
        Line2D.Double doorhandle = new Line2D.Double(r1, r11);

        // drawing everything
        g2.draw(body);
        g2.draw(roof);
        g2.draw(wall2);
        g2.draw(wall3);
        g2.draw(wall4);
        g2.draw(wall5);
        g2.draw(wall7);
        g2.draw(wall8);
        g2.draw(wall9);
        g2.draw(door);
        g2.draw(window);
        g2.draw(window2);
        g2.draw(doorhandle);

    }
}
