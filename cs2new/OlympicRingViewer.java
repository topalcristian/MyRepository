import javax.swing.JFrame;

public class OlympicRingViewer {

    public static void main(String[] args) {

        // creating frame
        JFrame frame = new JFrame();
        final int FRAME_WIDTH = 700;
        final int FRAME_HEIGHT = 500;
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Olympic Rings");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add OlympicRings component to frame
        OlympicRingsComponent component = new OlympicRingsComponent();
        frame.add(component);
        frame.setVisible(true);
    }

}
