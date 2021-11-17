import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        //items
        Item sword = new Item("Excalibur", "Excalibur is the legendary sword of King Arthur.");
        //enemies
        Enemy bat = new Enemy(1, "A Weak bat");
        Enemy dragon = new Enemy(100, "A Mighty dragon.");
        //end of the game
        Situation end = new Situation("Game over", null);
        //choices for the first situation
        Choice startChoice1 = new Choice("Go inside", null);
        Choice startChoice2 = new Choice("Go back to town", end);
        ArrayList<Choice> startChoices= new ArrayList<Choice>(List.of(startChoice1, startChoice2));
        //first situation initialization
        Situation start = new Situation("You stand before the cave entrance.", startChoices);

        //player initialization
        Player player = new Player(start);
        System.out.println(player.getCurrentSituation().getDescription());


    }
}
