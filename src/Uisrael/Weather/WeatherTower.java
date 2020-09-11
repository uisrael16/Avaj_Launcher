package Weather;

import Aircrafts.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates)
    {
       // System.out.println("We are here");
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather(){
        this.conditionsChanged();
    }   
}