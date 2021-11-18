import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller<Type extends Choice> {
    /*
    Třída, která má nastarosti komunikaci s uživatelem. Ukazuje mu možnosti poté čeká na uživatelský input. Po zadání správného
    inputu, předá input třídě player.

    Class communicates with player. It shows him the options he have and then waits for his input. After correct input has
    been accepted, it sends the input to the player class.
     */
    private Situation nextSituation;
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
            try {
                if(this.player.getCurrentSituation() instanceof SituationWin ) { //if player wins we break loop
                    this.player.getCurrentSituation().execute();
                    break;
                }
                this.player.getCurrentSituation().execute();
                int maxIndex = this.showChoices();
                this.userInput = this.getUserInput(maxIndex);
                if(this.userInput == maxIndex - 1){ //setting menu
                    this.options();
                }
                else {
                    this.nextSituation = this.player.getCurrentSituation().getChoice(userInput - 1).getTargetSituation();
                    this.player.setCurrentSituation(this.nextSituation);
                }
            } catch (InputMismatchException e){
                System.out.println("Wrong input please try again: ");
            }
            catch (Exception e){
                System.out.println(e);
                break;
            }

        }
    }

    public void options() throws IOException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Options");
        System.out.println("1 : Save the game");
        System.out.println("2 : load last save: ");
        System.out.println("3 : exit menu");
        System.out.println("4 : exit the game");
        System.out.print("Select: ");
        int userInput = scan.nextInt();
        while (userInput <= 0 || userInput > 4){
            System.out.print("Wrong number, please select again: ");
            userInput = scan.nextInt();
        }
        switch (userInput) {
            case 1:
                this.fileManager.saveTheGame();
                break;
            case 2:
                this.fileManager.loadTheGame();
                break;
            case 3:
                break;
            case 4:
                this.player.setCurrentSituation(new SituationWin("\nThank you for playing"));
                break;
        }

    }

    public int showChoices(){
        //returns maximal value for viable input
        int i = 1;
        //this.player.getCurrentSituation().getChoices().add();
        for (Choice choice:
             this.player.getCurrentSituation().getChoices()) {
            if(choice instanceof Choice){
                System.out.println( i + " : " + ((Choice) choice).getDescription() + "\n");
                i++;
            }
        }
        System.out.println(i + " : " + "Options menu" + "\n");
        i++;
        return i;
    }

    public int getUserInput(int maxIndex) {
        Scanner scan = new Scanner(System.in);
        System.out.print("What will you do?: ");
        int userInput = scan.nextInt();
        while ( maxIndex + 2  < userInput || userInput <= 0){ //we start from 1 and we have menu option that's why + 2
            System.out.print("Wrong number, please select again: ");
            userInput = scan.nextInt();
        }
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
