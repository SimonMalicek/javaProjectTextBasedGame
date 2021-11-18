import java.util.ArrayList;

public class SituationTakeDamage extends Situation{
    /*
    Situace po které se hráči uberou životy

    Situation after which player receive damage.
     */
    Player player;
    int dmg;

    SituationTakeDamage(String description, ArrayList<Choice> choices, Player player, int dmg) {
        super(description, choices);
        this.player = player;
        this.dmg = dmg;
    }

    @Override
    public void execute(){
        System.out.println(super.getDescription() + "\n");
        player.receiveDmg(dmg);
    }
}
