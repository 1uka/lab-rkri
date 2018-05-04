package lab05;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener {
  private int timePassed;
  private JLabel timeLabel;
  private NumberLabel[] numbers;

  public TimerListener(JLabel timeLabel, NumberLabel[] numbers) {
    this.timeLabel = timeLabel;
    this.numbers = numbers;
    timePassed = 0;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    timeLabel.setText("Passed: " + ++timePassed/10 + " seconds");
    for(int i = 0; i < numbers.length; i++) {
      numbers[i].move();
    }
  }
}
