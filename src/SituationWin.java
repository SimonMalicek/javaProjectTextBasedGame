import java.util.ArrayList;

public class SituationWin extends Situation{
    /*
    Poslední situace ve hře, nemá choices protože se hra pro této situaci ukončí
     */
    SituationWin(String description) {
        super(description, null); //we will never reach these choices
    }

    public void execute(){
        System.out.println(this.getDescription());
    }
}
