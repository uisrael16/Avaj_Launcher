package Aircrafts;

public class Coordinates {
    
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height){
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
        if ((longitude < 0) || (latitude < 0) || (height < 0)){
            longitude = 0;
            latitude = 0;
            height = 0;
        }
        else if (height > 100)
            height = 100;

    }
    public int getLongitude(){
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int  getHeight(){
        return this.height;
    }
}