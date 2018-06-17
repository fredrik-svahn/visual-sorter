import javax.swing.*;
import java.awt.*;

public class Renderer extends JPanel {
    private JFrame frame;
    private int[] array;

    public Renderer() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
    }

    /**
     * Get the index that contains the largest integer in the array.
     * @return
     */
    private int getMax(int[] array) {
        int max = 0;

        for(int i = 0; i < array.length; i++) {
            if(array[i] > array[max]) {
                max = i;
            }
        }

        return max;
    }
}
