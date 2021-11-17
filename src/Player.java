import java.util.ArrayList;

public class Player extends Creature implements Damageable{
    public int hp = 5;
    public Situation currentSituation, nextSituation;
    public ArrayList<Item> inventory = new ArrayList<Item>();

    Player(Situation startingSituation) {
        this.currentSituation = startingSituation;
    }

    public void receiveDmg(int dmg) {
        this.hp -= dmg;
    }

    public boolean isAlive() {
        return this.hp >= 0;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setCurrentSituation(Situation currentSituation) {
        this.currentSituation = currentSituation;
    }

    public Situation getNextSituation() {
        return nextSituation;
    }

    public void setNextSituation(Situation nextSituation) {

        this.nextSituation = nextSituation;
    }

    public Situation getCurrentSituation() {
        return currentSituation;
    }

    //Inventory
    public void addItem(Item item){
        inventory.add(item);
    }

    public void removeItem(Item item){
        inventory.remove(item);
    }

    public boolean hasItem(Item item) {return  inventory.contains(item);}

    @Override
    public String getDescription() {
        return "Player character";
    }
}
