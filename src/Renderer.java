import javax.swing.*;
import java.awt.*;
import java.util.Random;

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


        array = generateArray(100, 100);
    }

    /**
     * Generate a random array of a certain size and maximum element value.
     * @param size
     * @param max
     * @return
     */
    public int[] generateArray(int size, int max) {
        Random rd = new Random();

        for(int i = 0; i < size; i++) {
            array[i] = rd.nextInt(max);
        }

        return array;
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
