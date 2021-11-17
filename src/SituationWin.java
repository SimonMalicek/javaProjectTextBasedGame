import java.util.ArrayList;

public class SituationWin extends Situation{
    SituationWin(String description) {
        super(description, null); //we will never reach these choices
    }

    public void execute(){
        System.out.println(this.getDescription());
        this.execute();
    }
}
