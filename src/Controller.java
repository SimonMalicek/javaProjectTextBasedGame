import java.util.Scanner;

public class Controller<Type extends Choice> {
    /*
    Třída, která má nastarosti komunikaci s uživatelem. Ukazuje mu možnosti poté čeká na uživatelský input. Po zadání správného
    inputu, předá input třídě player.

    Class communicates with player. It shows him the options he have and then waits for his input. After correct input has
    been accepted, it sends the input to the player class.
     */
    private Situation currentSituation, nextSituation;
    private int userInput;
    private Player player;
    FileManager fileManager;

    Controller(Player player, FileManager fileManager) {
        this.player = player;
        this.fileManager = fileManager;
    }

    public void gameStart(){
        this.loop();
    }

    public void loop(){
        while(true){
            this.player.getCurrentSituation().execute();
            int maxIndex = this.showChoices();
            this.userInput = this.getUserInput(maxIndex);
            this.nextSituation = this.currentSituation.getChoice(userInput - 1).getTargetSituation();
            this.player.setNextSituation(this.nextSituation);
            System.out.println(player.currentSituation.getDescription());
        }
    }
    public void gameOverOptions(){
        Scanner scan = new Scanner(System.in);
        System.out.println("1: Load last save 2: Exit");
        try{
            int userInput = scan.nextInt();


        }catch(Exception e){
            System.out.println("Invalid input");
            gameOverOptions();
        }

    }

    public int showChoices(){
        //returns maximal value for viable input
        int i = 1;
        for (Choice choice:
             this.player.getCurrentSituation().getChoices()) {
            if(choice instanceof Choice){
                System.out.println(i + " :" + ((Choice) choice).getDescription() + "\n");
                i++;
            }

        }
        System.out.println(i + " :" + "Options menu" + "\n");
        i++;
        return i;
    }

    public Situation getCurrentSituation(){
        return this.currentSituation;
    }

    public int getUserInput(int maxIndex) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What will you do?: ");
        int userInput = scan.nextInt();
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
