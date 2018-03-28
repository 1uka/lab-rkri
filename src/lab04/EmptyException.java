package lab04;

public class EmptyException extends Exception {

  static final long serialVersionUID = 0;

  public EmptyException() {
    super("Cannot leave empty fields");
  }
}