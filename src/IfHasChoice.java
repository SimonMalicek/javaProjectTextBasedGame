public class IfHasChoice extends Choice{
    /*
    Volba s podminkou
    npr.: volba zautocit na draka (pokud ma hrac mec => vyhraje, pokud hrac nema mec => prohraje)

    Choice with a Condition.

    e.g.: Attack dragon (if the player has a sword => he kills the dragon, if player doesn't have a sword he dies)
     */
    Situation situationTrue, situationFalse;
    Item item;
    Player player;

    IfHasChoice(String description, Player player, Item item, Situation situationTrue, Situation situationFalse) {
        super(description, situationTrue);
        this.player = player;
        this.item = item;
        this.situationTrue = situationTrue;
        this.situationFalse = situationFalse;
    }

    public Situation getTargetSituation(){
        if(this.player.hasItem(item)){
            super.setTargetSituation(this.situationTrue);
        }
        else {
            super.setTargetSituation(this.situationFalse);
        }
        return super.getTargetSituation();
    }
}
