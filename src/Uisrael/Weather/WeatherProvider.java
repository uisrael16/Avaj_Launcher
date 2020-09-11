package Weather;

import Aircrafts.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();

    private static String[] weather = {"RAIN",
                                        "FOG",
                                        "SUN",
                                         "SNOW"
                                        };

    private WeatherProvider(){

    }
    public static WeatherProvider getProvider(){
        return WeatherProvider.weatherProvider;
    }
    public String getCurrentWeather(Coordinates coordinates){
        int times = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
        return weather[times % 4];
    }
}
