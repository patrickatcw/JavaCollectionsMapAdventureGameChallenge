package patrick;

import java.util.HashMap;
import java.util.Map;

//class
public class Location {

    //fields or variables
    private final int locationID;
    private final String desription;
    private final Map<String, Integer> exits;

    //constructor, for location id and description
    public Location(int locationID, String desription) {
        this.locationID = locationID;
        this.desription = desription;
        //manually set our exits up
        this.exits = new HashMap<String, Integer>();
    }

    //method for adding exits
    public void addExit(String direction, int location){
        exits.put(direction, location);

    }

    //getters for all
    public int getLocationID() {
        return locationID;
    }

    public String getDesription() {
        return desription;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }
}
