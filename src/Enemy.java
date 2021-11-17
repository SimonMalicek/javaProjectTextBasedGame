public class Enemy extends Creature{
    Enemy(int hp, String description){
        this.hp = hp;
        this.description = description;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
