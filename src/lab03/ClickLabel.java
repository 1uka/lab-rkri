package lab03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickLabel implements MouseListener {
  private JLabel lbl;
  private JList<String> colors;

  public ClickLabel(JLabel lbl) {
    this.lbl = lbl;
    DefaultListModel<String> lm = new DefaultListModel<>();
    lm.addElement("Red");
    lm.addElement("Green");
    lm.addElement("Blue");
    lm.addElement("Default");
    colors = new JList<>(lm);
    colors.setBounds(468, 90, 65, 113);
    colors.setVisible(false);
    colors.addListSelectionListener(new ColorListener(lbl));
    ((JFrame)SwingUtilities.getRoot(lbl)).getContentPane().add(colors);
  }


  @Override
  public void mouseClicked(MouseEvent e) {
    Object comp = e.getSource();
    if(e.getClickCount() == 2) {
      if(comp instanceof JLabel) {
        lbl.setVisible(false);
        JTextField tf = new JTextField();
        tf.setText(lbl.getText());
        tf.setBounds(lbl.getBounds());
        tf.addMouseListener(new ClickLabel(lbl));
        ((JFrame)SwingUtilities.getRoot(lbl)).add(tf);
      } else if(comp instanceof JTextField) {
        JTextField tf = (JTextField) comp;
        tf.setVisible(false);
        lbl.setText(tf.getText());
        ((JFrame)SwingUtilities.getRoot(lbl)).remove(tf);
        lbl.setVisible(true);
      }
    }

    if(e.getModifiers() == MouseEvent.BUTTON3_MASK) {
      System.out.println("Right clickin...");
      colors.setVisible(true);
    }
  }

  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }
}
