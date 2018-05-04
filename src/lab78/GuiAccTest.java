package lab78;



import sun.swing.BakedArrayList;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.Array;
import java.util.*;
import java.lang.reflect.*;




class GuiAccTest extends Frame implements ActionListener, ItemListener
{
  Label lab=new Label("                                                                                                                                                                 ");
  Label lab1=new Label("                                                                                                                                                                 ");
  TextField t[]=new TextField [4];
  Label l[]=new Label [5];
  Button but=new Button("Create Account");
  Button but1=new Button("Test Account");
  JComboBox existing=new JComboBox();
  BankAccount b;
  ArrayList<BankAccount> acclist = new ArrayList<>();
  ArrayList<BankAccount> acclisttest = new ArrayList<>();

  int i = 5;

  GuiAccTest()
  {
    addWindowListener(new NewWindowAdapter());
    setLayout(new GridLayout(2,0));
    Panel p=new Panel();
    Panel p1=new Panel();
    but.addActionListener(this);
    but1.addActionListener(this);
    p.setLayout(new GridLayout(7,2));
    p1.add(lab1);
    p1.add(lab);
    l[0]=new Label("Account Number");
    l[1]=new Label("Initial Balance");
    l[2]=new Label("Deposit Amount");
    l[3]=new Label("Withdraw Amount");
    l[4]=new Label("Existing Accounts");

    existing.addItemListener(this);
    for(int i=0;i<4;i++)
    {
      t[i]=new TextField(10);
      p.add(l[i]);
      p.add(t[i]);
    }
    p.add(l[4]);
    p.add(existing);
    p.add(but);
    p.add(but1);
    but1.setVisible(false);
    l[2].setVisible(false);
    l[3].setVisible(false);
    t[2].setVisible(false);
    t[3].setVisible(false);
    add(p);
    add(p1);
  }

  String testAccount(int d_amt,int w_amt)
  {
    String msg;
    b.deposit(d_amt);
    msg="Transaction Succesful";
    try
    {
      b.withdraw(w_amt);
    }catch(FundsInsufficientException fe)
    {
      fe=new FundsInsufficientException(b.amount,w_amt);
      msg=String.valueOf(fe);
    }
    return msg;
  }

  public void actionPerformed(ActionEvent ae)
  {

    String str=ae.getActionCommand();

    if(str.equals("Create Account"))
    {
      if(i != 0) {
        b = new BankAccount(Integer.parseInt(t[0].getText()),Integer.parseInt(t[1].getText()));
        acclist.add(b);
        i=i-1;
        lab1.setText("Momentalo ja vnesovte "+i+"bankasrsa smetka"+acclist.size());
      }
      if(i==0) {
        try {
          FileOutputStream fos = new FileOutputStream("test.txt");
          ObjectOutputStream oos = new ObjectOutputStream(fos);
          oos.writeObject(acclist);
          oos.flush();
          oos.close();
        } catch (Exception ex) {
          ex.printStackTrace();
        }

        acclist.forEach(b -> existing.addItem(b.accnum));

        but1.setVisible(true);
        l[2].setVisible(true);
        l[3].setVisible(true);
        t[2].setVisible(true);
        t[3].setVisible(true);
        but.setVisible(false);
        l[0].setVisible(false);
        l[1].setVisible(false);
        t[0].setVisible(false);
        t[1].setVisible(false);
        lab1.setText("Account : "+b.accnum+", Current Balance : "+b.amount);
        return;
      }
    } else {
      lab.setText(testAccount(Integer.parseInt(t[2].getText()),Integer.parseInt(t[3].getText())));
      lab1.setText("Account : "+b.accnum+", Current Balance : "+b.amount);
      try {
        FileOutputStream fo = new FileOutputStream("test.txt");
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        BankAccount bankAccount = new BankAccount(Integer.parseInt(t[0].getText()),Integer.parseInt(t[1].getText()));
        oo.writeObject(bankAccount);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void itemStateChanged(ItemEvent evt) {
    JComboBox cb = (JComboBox) evt.getSource();

    Object item = evt.getItem();
    String selected_item = String.valueOf(item);
    if (evt.getStateChange() == ItemEvent.SELECTED) {
      t[2].setText("");
      t[3].setText("");

      but1.setVisible(true);
      l[2].setVisible(true);
      l[3].setVisible(true);
      t[2].setVisible(true);
      t[3].setVisible(true);
      but.setVisible(false);
      l[0].setVisible(false);
      l[1].setVisible(false);
      t[0].setVisible(false);
      t[1].setVisible(false);

    } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
      // Item is no longer selected
    }
  }

  public static void main(String arg[]) throws ClassNotFoundException {
    GuiAccTest at=new GuiAccTest();
    at.setTitle("Bank Account Tester");
    at.setSize(600,300);
    at.setVisible(true);
  }
}
class NewWindowAdapter extends WindowAdapter
{
  public void windowClosing(WindowEvent we)
  {
    System.exit(0);
  }
}


class FundsInsufficientException extends Exception
{
  int balance;
  int withdraw_amount;
  FundsInsufficientException(int bal,int w_amt)
  {
    balance=bal;
    withdraw_amount=w_amt;
  }
  public String toString()
  {
    return "Your withdraw amount ("+withdraw_amount+") is less than the balance ("+balance+"). No withdrawal was recorded.";
  }

}