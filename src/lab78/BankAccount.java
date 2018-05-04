package lab78;

import java.io.Serializable;

public class BankAccount implements Serializable
{
  public int accnum;
  public int amount;
  private int type;
  public BankAccount(int accnum) {
    this.accnum = accnum;
  }

  public BankAccount(int num, int amt)
  {
    accnum=num;
    amount=amt;
  }
  public void deposit(int amt)
  {
    amount=amount+amt;
  }
  public void withdraw(int amt) throws FundsInsufficientException
  {
    if(amt>amount)
      throw new FundsInsufficientException(amount,amt);
    else
      amount=amount-amt;
  }


  public int getAccnum() {
    return accnum;
  }

  public int getAmount() {
    return amount;
  }

  public void setAccnum(int accnum) {
    this.accnum = accnum;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }
}
