import java.util.ArrayList;

public class Situation implements Describable{
    public String description;
    public ArrayList<Choice> choices;

    Situation(String description, ArrayList<Choice> choices) {
        this.description = description;
        this.choices = choices;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public ArrayList<Choice> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<Choice> choices) {
        this.choices = choices;
    }

    public Choice getChoice(int index){
        return choices.get(index);
    }

    public void addChoice(Choice choice){
        this.choices.add(choice);
    }
}
