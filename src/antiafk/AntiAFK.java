/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antiafk;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
/**
 *
 * @author Inroger
 */
public class AntiAFK {

    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    static JButton cancelButton = new JButton();
    static JLabel timeLabel = new JLabel();

    static int time = 60; // time in seconds
    static boolean stop = false;

    public static void main(String[] args) {
        try {
            Robot robot = new Robot();

            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(300, 100);
            frame.setLocationRelativeTo(null);
            frame.setTitle("Anti AFK");
            frame.setResizable(false);

            panel.setLayout(null);

            cancelButton.setText("Cancel");
            cancelButton.setBounds(100, 50, 100, 25);
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stop = true;
                    frame.dispose();
                }
            });
            panel.add(cancelButton);

            timeLabel.setText("Time left: " + time + "s");
            timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            timeLabel.setBounds(0, 0, 300, 50);
            panel.add(timeLabel);

            frame.add(panel);
            frame.setVisible(true);

            while (!stop) {
                timeLabel.setText("Time left: " + time + "s");
                time--;
                robot.mouseMove(100, 100);
                Thread.sleep(1000);
                if (time == 0) {
                    time = 60;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
