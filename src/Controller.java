public class Controller {
    /*
    Třída, která má nastarosti komunikaci s uživatelem. Ukazuje mu možnosti poté čeká na uživatelský input. Po zadání správného
    inputu, předá input třídě player.

    Class communicates with player. It shows him the options he have and then waits for his input. After correct input has
    been accepted, it sends the input to the player class.
     */

    private Situation currentSituation;
    private int userInput;
    private Situation nextSituation;
    private Player player;

    Controller(){}

    public void setCurrentSituation(Player player,Situation situation){
        this.player = player;
        this.loop();
    }

    public void loop(){
        while(true){
            this.currentSituation = this.player.getCurrentSituation();
            this.showChoices();
            this.userInput = this.getUserInput();
            this.nextSituation = this.currentSituation.getChoice(userInput).getTargetSituation();
            this.player.setNextSituation(this.nextSituation);
            while(true){
                if(player.getCurrentSituation() != this.currentSituation){ //prevent the showing of the same options twice
                    break;
                }
            }
        }
    }

    public void showChoices(){

    }

    public Situation getCurrentSituation(){
        return this.currentSituation;
    }

    public int getUserInput() {
        return userInput;
    }

    public Situation getNextSituation() {
        return nextSituation;
    }

    public void setUserInput(int userInput) {
        this.userInput = userInput;
    }

    public void setNextSituation(Situation nextSituation) {
        this.nextSituation = nextSituation;
    }

}
