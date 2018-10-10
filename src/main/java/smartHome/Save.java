package smartHome;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;

class Test implements Serializable {
  String content;
  int value;
}

public class FileUtil {
  public static void main(String[] args) {
    Test test = new Test();
    test.content = "DKM";
    test.value = 2;
    try {
      File file = new File("/Users/nhannt/Projects/test.ser");
      FileOutputStream fout = new FileOutputStream(file);
      ObjectOutputStream oos = new ObjectOutputStream(fout);
      oos.writeObject(test);
      oos.close();
      fout.close();
    } catch (Exception e) {
            
    }
    try {
      File file = new File("/Users/nhannt/Projects/test.ser");
      FileInputStream fi = new FileInputStream(file);
      ObjectInputStream oi = new ObjectInputStream(fi); 
      
      Test savedTest = (Test) oi.readObject();
      System.out.println("dk" + savedTest.content + savedTest.value);
    }catch(Exception e){
      System.out.println("" + e.getMessage());
    }

  }
}

