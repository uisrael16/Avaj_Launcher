import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Aircrafts.AircraftFactory;
import Weather.WeatherTower;

public class Main {
    public static int index;
    private static  WeatherTower weatherTower = new WeatherTower();           
    
    public static void main(String[] args) throws IOException {
       
        if (args.length == 1) {
            try {
                File myfile = new File(args[0]);
                Scanner arg = new Scanner(myfile);
                ArrayList<String> data = new ArrayList<String>();
                int i = 0;
                while (arg.hasNextLine()) {
                    data.add(arg.nextLine());
                }
                arg.close();

                if (data.get(0) != null) {
                     index = Integer.parseInt(data.get(0));
                    if (index < 0) {
                        System.err.println("incorrect number " + index + " number cant be a Negetive");
                        System.exit(1);   
                    }           
                }                    
            {
                   
                 i = 1;
                while (i < data.size()) {
                    String line[] = data.get(i).split("\\s+");
                    
                    if (line.length != 5) {
                        System.err.println("Params must be 5 ");
                        System.exit(1);
                    }

                    try {
                            AircraftFactory.newAircraft(line[0], line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4])).registerTower(weatherTower);
                            
                        } catch (Exception e) {
                            System.out.println("couldn't get the coordinates");
                            System.exit(1);
                        }
                       i++;
                    }               
                    weatherTower.changeWeather();
                }
               
            } catch (FileNotFoundException e) {
                System.out.println("Invalid File");
            } 
                
        }
        else {
             System.err.println("No Param");
        }
        while (index > 0)
        {
            weatherTower.changeWeather();
            index--;
        } 
    }
}