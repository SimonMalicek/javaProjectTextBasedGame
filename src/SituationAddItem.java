import java.awt.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.function.Supplier;

public class SituationAddItem extends Situation{
    /*
    Situace ve ktera hraci das item.

    You add item to the player.
     */
    Player player;
    Item item;

    SituationAddItem(String description, ArrayList<Choice> choices, Player player, Item item) {
        super(description, choices);
        this.player = player;
        this.item = item;

    }

    @Override
    public void execute(){
        System.out.println(super.getDescription());
        Supplier<Item> itemSupplier = () -> item;
        this.player.addItem(itemSupplier.get());
    }
}
