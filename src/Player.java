import java.util.ArrayList;

public class Player extends Creature implements Describable{
    /*
    V této třídě jsou uložené stavy hry, po kterých hráč putuje.
    Hráč má životy, pokuď klesnou pod 1, skončí hra.
    Hráč má inventář, kde postupně sbírá itemy ve hře.


     */
    public int hp = 5;
    public Situation currentSituation, nextSituation, gameOver;
    public ArrayList<Item> inventory = new ArrayList<Item>();

    Player(){
    }

    public void setMainSituations(Situation startingSituation, Situation gameOver) {
        this.currentSituation = startingSituation;
        this.gameOver = gameOver;
    }

    public void receiveDmg(int dmg) {
        this.hp -= dmg;
        if (this.hp < 1){
            this.nextSituation = gameOver;
            System.out.println("You've fallen in the battle.");
            this.nextSituation.execute();
        }
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

    public void setCurrent(Situation nextSituation) {

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

    //
    public void setNextSituation(Situation nextSituation) {
        this.nextSituation = nextSituation;
    }
}
