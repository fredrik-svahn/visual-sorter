import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Set;

public class Renderer extends JPanel {
    private JFrame frame;
    private int[] array;
    private Sorter sorter;

    public static void main(String[] args) {
        Renderer renderer = new Renderer();
        renderer.start();
    }

    public Renderer() {
        array = generateArray(300, 100);
        sorter = new SelectionSorter();

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 200);
        frame.setLocationRelativeTo(null);
        frame.add(this);

        frame.setVisible(true);
    }

    public synchronized void start() {
        sorter.delay = 10;
        Thread thread = new Thread(() -> sorter.sort(array));
        thread.start();


        while (true) {
            repaint();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Generate a random array of a certain size and maximum element value.
     *
     * @param size
     * @param max
     * @return
     */
    public int[] generateArray(int size, int max) {
        Random rd = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = rd.nextInt(max);
        }

        return array;
    }

    @Override
    public void paintComponent(Graphics g) {
        int max = getMax(array);
        int barWidth = getWidth() / array.length;

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());


        g.setColor(Color.WHITE);
        double maxValue = array[max];

        int[] swapIndex = sorter.swapIndeces;
        int selectA = sorter.selectedA;
        int selectB = sorter.selectedB;

        for (int i = 0; i < array.length; i++) {

            if (i == selectA || i == selectB) {
                g.setColor(Color.GREEN);
            }
            else if(i == swapIndex[0] || i == swapIndex[1]) {
                g.setColor(Color.RED);
            }
            else {
                g.setColor(Color.WHITE);
            }



            int barHeight = (int) Math.floor((array[i] / maxValue) * getHeight());
            g.fillRect(i * barWidth, getHeight() - barHeight, barWidth, barHeight);
        }

    }

    /**
     * Get the index that contains the largest integer in the array.
     *
     * @return
     */
    private int getMax(int[] array) {
        int max = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[max]) {
                max = i;
            }
        }

        return max;
    }
}
