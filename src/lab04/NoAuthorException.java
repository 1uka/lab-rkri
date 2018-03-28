package lab04;

/**
 * NoAuthorException
 */
public class NoAuthorException extends Exception {
  
  static final long serialVersionUID = 1;

  public NoAuthorException() {
    super("Must fill author if selected");
  }
}