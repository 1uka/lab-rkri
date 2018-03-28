package lab03;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class ColorListener implements ListSelectionListener {
  private JLabel _lbl;
  public ColorListener(JLabel lbl) {
    _lbl = lbl;
  }

  @Override
  public void valueChanged(ListSelectionEvent e) {
    if(!e.getValueIsAdjusting()) {
      try {
        JList<String> list = (JList<String>) e.getSource();
        String c = list.getSelectedValue();
        switch(c) {
          case "Default": _lbl.setForeground(Color.BLACK); break;
          case "Red":     _lbl.setForeground(Color.RED); break;
          case "Green":   _lbl.setForeground(Color.green); break;
          case "Blue":    _lbl.setForeground(Color.BLUE); break;
        }
        list.setVisible(false);
      } catch (NullPointerException err) {
        JOptionPane.showMessageDialog(null, "null pointer caught");
        System.out.println("Error: " + err);
      }
    }
  }
}
