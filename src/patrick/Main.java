package patrick;
//based on Colossal Cave Adventure Game of the 70's
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    /*challenge directions;
    - change the program to allow players to type full words, or phrases, then
    move to the correct location based upon their input
    - the player should be able to type commands such as "go west", or just "east"
    and the program will move to the appropriate location if there is one. as at
    present, an attempt to move in an invalid direction should print a message
    and remain in the same place
    - single letter commands (n, w, s, e, q) should still be available
     */

    //initializing hashmap
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {

        //instance for scanner
        Scanner scanner = new Scanner(System.in);

        //locations
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing by a small building"));
        locations.put(2, new Location(2, "You are on a hill"));
        locations.put(3, new Location(3, "You are inside a building"));
        locations.put(4, new Location(4, "You are by a stream"));
        locations.put(5, new Location(5, "You are in a scary forest"));

        //exits for each location, had to change these
        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

        //challenge step 1, create a map for vocabulary
        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");

        //while loop
        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDesription());
            if (loc == 0) {
                break;
            }

            //directions
            Map<String, Integer> exits = locations.get(loc).getExits(); //returning actual location object
            System.out.print("Available exits are ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            //scanner instance
            String direction = scanner.nextLine().toUpperCase();

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
                //run, working

            }

        }


    }

}



