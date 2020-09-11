package Weather;

import java.util.ArrayList;

import Interface.Flyable;

public abstract class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();
    private static int count = 0;
    

    public void register(Flyable flyable){
        observers.add(flyable);
    }

    public void unregister(Flyable flyable){
        count = 1;
        observers.remove(flyable);
    }

    /**
     * This iterate through a list of flyables and calls for update of each
     * flyable's condition
     */
    protected void conditionsChanged(){
        for (int i = 0; i < observers.size(); i++){
            if(count == 1){
                i--;
                count = 0;

            }
            observers.get(i).updateConditions();
           
        }
    }
}