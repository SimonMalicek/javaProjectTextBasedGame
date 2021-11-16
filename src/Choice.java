public class Choice {
    /*
    Volba, říká hráči co udělá.

    The choice shows what will player do.
     */
    public String description = "Place holder desc";
    private Situation targetSituation;//Do jaké situace pošle hráče pokuď si zvolí tuto možnost | Where will be player sent after choosing the choice

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

    public void print(int index){
        System.
    }
}
