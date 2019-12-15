import javax.swing.JFrame;

public class HouseViewer {

    public static void main(String[] args) {

        // creating frame
        JFrame frame = new JFrame();
        final int FRAME_WIDTH = 1000;
        final int FRAME_HEIGHT = 900;
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("modern mansion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add House component to frame
        HouseComponent component = new HouseComponent();
        frame.add(component);
        frame.setVisible(true);
    }
}
