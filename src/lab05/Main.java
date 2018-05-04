package lab05;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
  private JFrame frame;
  private NumberLabel[] labels;

  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      try {
        Main window = new Main();
        window.frame.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  public Main() {
    init();
  }

  public void init() {
    frame = new JFrame();
    frame.setBounds(100, 100, 600, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    JLabel time = new JLabel("Passed: 0 seconds");
    time.setBounds(0, 0, 150, 30);
    frame.getContentPane().add(time);

    labels = new NumberLabel[10];
    Random rand = new Random();
    for (int i = 0; i < labels.length; i++) {
      Integer r = rand.nextInt(10) + 1;
      labels[i] = new NumberLabel(r.toString());
      labels[i].setBounds(0, i*50 + rand.nextInt(30), 30, 30);
      frame.getContentPane().add(labels[i]);
    }

    Timer t = new Timer(1000, new TimerListener(time, labels));
    t.setRepeats(true);
    t.start();
  }
}
