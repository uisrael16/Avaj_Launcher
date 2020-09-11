package Aircrafts;

import java.io.FileWriter;
import java.io.IOException;


public class WriteToFile {
    public static void writeToFile(String str) {
      try {
        FileWriter myWriter = new FileWriter("C:\\Users\\uisrael\\Downloads\\avaj_launcher\\src\\Uisrael\\simulation.txt",true);
        myWriter.write(str + '\n');
        myWriter.close();
        
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }
  }

