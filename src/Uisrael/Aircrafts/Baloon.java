package Aircrafts;

import Interface.Flyable;
import Weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    
    private WeatherTower weatherTower;
    
    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(coordinates);
       
        if (weather.equalsIgnoreCase("SUN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 2, coordinates.getLatitude() + 0, coordinates.getHeight() + 4);
            WriteToFile.writeToFile("Baloon# " + this.name + "(" + this.id  +")" + "Hello out there in this beautiful Sunny day");
        }

        else if (weather.equalsIgnoreCase("RAIN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 5, coordinates.getHeight() - 5);
            WriteToFile.writeToFile("Baloon# " + this.name + "(" + this.id  +")" + " Get your Rain suite ready... its raining out there!!!");
        }

        else if (weather.equalsIgnoreCase("FOG")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 0, coordinates.getHeight() - 3);
             WriteToFile.writeToFile("Baloon# " + this.name + "(" + this.id  +")" + " path is unclear... look out for Fog");
        }
        else if (weather.equalsIgnoreCase("SNOW")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 0, coordinates.getHeight() - 15);
             WriteToFile.writeToFile("Baloon# " + this.name + "(" + this.id  +")" + " we will freeze to death!!!");
        }
        if (this.coordinates.getHeight() < 1)
        {
            WriteToFile.writeToFile("Baloon# " + this.name + "(" + this.id  +")" +  "Baloon is now Landing.......**********");
            this.weatherTower.unregister(this);
            WriteToFile.writeToFile("Tower says: baloon# " + this.name + "(" + this.id + ")" + "Unregistered from the Tower");
         
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
         WriteToFile.writeToFile("Tower says: baloon# " + this.name + "(" + this.id + ")" + " Registered to the Tower");
     
    }
}