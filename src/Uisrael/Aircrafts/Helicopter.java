package Aircrafts;

import Interface.Flyable;
import Weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        //String weather = weatherTower.getWeather(this.coordinates);
        String weather = this.weatherTower.getWeather(coordinates);
        // WriteToFile.writeToFile("Helicopter# " + this.name + "(" + this.id +")");

        if (weather.equalsIgnoreCase("SUN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 10, coordinates.getLatitude() + 0, coordinates.getHeight() + 2);
            WriteToFile.writeToFile("Helicopter# " + this.name + "(" + this.id  +")" + "its a bright day out side there... its super hot!!!");
        } 
        else if (weather.equalsIgnoreCase("RAIN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 5, coordinates.getLatitude() + 0, coordinates.getHeight() + 0);
            WriteToFile.writeToFile("Helicopter# " + this.name + "(" + this.id  +")" + " I don't really like rain..... ");
        }
        else if (weather.equalsIgnoreCase("FOG")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 1, coordinates.getLatitude() + 0, coordinates.getHeight() + 0);
             WriteToFile.writeToFile("Helicopter# " + this.name + "(" + this.id  +")" + " the visibility is unclear because of the Fog");
        }
        else if (weather.equalsIgnoreCase("SNOW")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 0, coordinates.getHeight() + 12);
             WriteToFile.writeToFile("Helicopter# " + this.name + "(" + this.id  +")" + " please dress up warm... its cold out there!!");
        }
        if (this.coordinates.getHeight() < 1)
        {
            WriteToFile.writeToFile("Helicopter# " + this.name + "(" + this.id  +")" +  "Helicopter is now Landing.......");
            this.weatherTower.unregister(this);
            WriteToFile.writeToFile("Tower says: Helicopter# " + this.name + "(" + this.id + ")" + "Unregistered from the Tower");
         
           
        }

    }
    
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        WriteToFile.writeToFile("Tower says: Helicopter# " + this.name + "(" + this.id + ")" + " Registered to the Tower");
    }

   // @Override

}