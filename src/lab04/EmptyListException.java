package lab04;

/**
 * EmptyListException extends Exception
 */
public class EmptyListException extends Exception {

  static final long serialVersionUID = 2;

  public EmptyListException() {
    super("Cannot click empty list");
  }
}