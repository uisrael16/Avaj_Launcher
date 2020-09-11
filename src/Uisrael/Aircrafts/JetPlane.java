package Aircrafts;

import Interface.Flyable;
import Weather.WeatherTower;

public  class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane( String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
         String weather = weatherTower.getWeather(this.coordinates);

        if (weather.equalsIgnoreCase("SUN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
            WriteToFile.writeToFile("JetPlane# " + this.name + "(" + this.id  +")" + " OMG a shinny hot day!!!!");
        }
        else if (weather.equalsIgnoreCase("RAIN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 5, coordinates.getHeight() + 0);
             WriteToFile.writeToFile("JetPlane# " + this.name + "(" + this.id  +")" + " I hate raining weather");            
        }
        else if (weather.equalsIgnoreCase("FOG")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 1, coordinates.getHeight() + 0);
             WriteToFile.writeToFile("JetPlane# " + this.name + "(" + this.id  +")" + " fly careful these Fog out there");
                   
        }
        else if (weather.equalsIgnoreCase("SNOW")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 0, coordinates.getHeight() - 7);
             WriteToFile.writeToFile("JetPlane# " + this.name + "(" + this.id  +")" + " watch out for Snow");
        }
        
        if (this.coordinates.getHeight() < 1)
        {
            WriteToFile.writeToFile("JetPlane# " + this.name + "(" + this.id  +")" +  "JetPlane is now Landing.......*******");
            this.weatherTower.unregister(this);
            WriteToFile.writeToFile("Tower says: JetPlane# " + this.name + "(" + this.id + ")" + "Unregistered from the Tower");
        }
    }
    @Override
    public void registerTower( WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        
        WriteToFile.writeToFile("Tower says: JetPlane# " + this.name + "(" + this.id + ")" + " Registered to the Tower");
        
    }	
}