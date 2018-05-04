package lab05;

import javax.swing.*;
import java.util.Random;

public class NumberLabel extends JLabel {
  private Boolean xRebound, yRebound;
  private Integer n;
  private int randX, randY, xx, yy;

  public NumberLabel(String text) {
    super(text);
    n = Integer.parseInt(text);
    setRandomCoordinates();
  }

  public NumberLabel(JLabel lbl) {
    super();
    if(lbl == null) return;
    lbl.setLocation(lbl.getX(), lbl.getY());
    try {
      n = Integer.parseInt(lbl.getText());
    } catch (Exception e) {
      n = 0;
    }
    setRandomCoordinates();
  }

  public void setRandomCoordinates() {
    Random rand = new Random();
    setRandX(rand.nextInt(30) + 1);
    setRandY((rand.nextInt(30) + 1) - (rand.nextInt(30) + 1));
    setyRebound(getRandY() < 0);
  }

  public void prepareNewLocation() {
    xx = getxRebound() ? getX() - getRandX() : getX() + getRandX();
    yy = getyRebound() ? getY() - Math.abs(getRandY()) : getY() + Math.abs(getRandY());
  }

  public Boolean getxRebound() {
    return xRebound;
  }

  public void setxRebound(Boolean xRebound) {
    this.xRebound = xRebound;
  }

  public Boolean getyRebound() {
    return yRebound;
  }

  public void setyRebound(Boolean yRebound) {
    this.yRebound = yRebound;
  }

  public int getRandX() {
    return randX;
  }

  public void setRandX(int randX) {
    this.randX = randX;
  }

  public int getRandY() {
    return randY;
  }

  public void setRandY(int randY) {
    this.randY = randY;
  }

  private void resetText() {
    if(n > 0) {
      setText((--n).toString());
    }
  }

  private NumberLabel searchNereby() {
    NumberLabel lbl = null;
    for (int i = 5; i > -5; i--) {
      try {
        lbl = new NumberLabel((JLabel) SwingUtilities.getRootPane(this).getContentPane().findComponentAt(xx + i, yy + i));
      } catch (ClassCastException e) {
        continue;
      }
    }
    if(lbl != null && lbl.getX() == 0 && lbl.getY() == 0) {
      return null;
    }
    return lbl;
  }

  public void move() {
    if(getX() + getRandX() >= 600) {
      setxRebound(true);
    } else if(getX() - getRandX() <= 0) {
      setxRebound(false);
    }

    if(getY() + getRandY() >= 600) {
      setyRebound(true);
    } else if(getY() + getRandY() <= 0) {
      setyRebound(false);
    }

    prepareNewLocation();
    NumberLabel near = searchNereby();
    if(near != null) {
      if(Integer.parseInt(near.getText()) > n) {
        setRandomCoordinates();
        prepareNewLocation();
        resetText();
      } else if(Integer.parseInt(near.getText()) < n) {
        near.setRandomCoordinates();
        near.prepareNewLocation();
        near.setLocation(near.xx, near.yy);
        near.resetText();
      } else {
        setRandomCoordinates();
        prepareNewLocation();
        resetText();
        near.setRandomCoordinates();
        near.prepareNewLocation();
        near.setLocation(near.xx, near.yy);
        near.resetText();
        setLocation(xx, yy);
        return;
      }
    }
    setLocation(xx, yy);
    resetText();
  }


}
