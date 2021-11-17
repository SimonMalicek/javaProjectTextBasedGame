public class IfChoice extends Choice{
    /*
    Volba s podminkou
    npr.: volba zautocit na draka (pokud ma hrac mec => vyhraje, pokud hrac nema mec => prohraje)

    Choice with a Condition.

    e.g.: Attack dragon (if the player has a sword => he kills the dragon, if player doesn't have a sword he dies)
     */
    Situation situationTrue, situationFalse;
    boolean condition;

    IfChoice(String description,boolean condition, Situation situationTrue, Situation situationFalse) {
        super(description, situationTrue);
        if(condition){
            super.setTargetSituation(situationTrue);
        }
        else {
            super.setTargetSituation(situationFalse);
        }
        this.condition = condition;
    }

    public Situation getTargetSituation(){
        return super.getTargetSituation();
    }
}
