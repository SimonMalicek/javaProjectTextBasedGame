import java.io.Serializable;

public class Choice implements Describable, Serializable {
    /*
    Volba, má popis, který Controller vypíše do konzole. Má targetSituation do které se hráč přemístí, pokud si možnost zvolí.

    Player can chooce Choice in the terminal, after that player will move to the targetSituation.
     */
    public String description = "Place holder desc";
    public Situation targetSituation;//Do jaké situace pošle hráče pokuď si zvolí tuto možnost | Where will be player sent after choosing the choice

    Choice(String description, Situation targetSituation){
        this.description = description;
        this.targetSituation = targetSituation;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setTargetSituation(Situation newSituation){
        this.targetSituation = newSituation;
    }

    public String getDescription(){
        return this.description;
    }

    public Situation getTargetSituation(){
        return this.targetSituation;
    }
}
