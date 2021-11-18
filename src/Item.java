import java.io.Serializable;

public record Item(String name, String description) implements Describable, Serializable {
    /*
    Třída ze které se vytváří item do inventáře hráč.

    Class for items, that will be in player's inventory
     */
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return (name + ":" + description);
    }
}
