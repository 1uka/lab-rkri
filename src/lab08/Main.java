package lab08;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  static ArrayList<Object> acclist = new ArrayList<>();

  public static void main(String[] args) {
    try {
      FileInputStream fin = new FileInputStream("/Users/luka/Desktop/Faks/rkri/lab/test.txt");
      ObjectInputStream ois = new ObjectInputStream(fin);
      acclist = (ArrayList<Object>) ois.readObject();
      Class c = acclist.get(0).getClass();
      System.out.println("Class name: " + c.getName());
      Constructor[] constructors = c.getConstructors();
      System.out.println("Constructors:" + Arrays.toString(constructors));
      Method[] methods = c.getMethods();
      System.out.println("Methods: " + Arrays.toString(methods));
      Field[] fields = c.getFields();
      for (Field f : fields) {
        Field field = c.getField(f.getName());
        Object type = field.getType();
        Object value = field.get(acclist.get(0));
        System.out.println("Value of " + field.getName() + " is " + value);
      }

      for (Object obj : acclist) {
        System.out.println("Account: " + obj.getClass().getField("accnum").get(obj));
        System.out.println("Amount: " + obj.getClass().getField("amount").get(obj));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
