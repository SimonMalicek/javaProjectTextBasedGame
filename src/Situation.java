import java.util.ArrayList;


public class Situation implements Describable{
    /*
    "buňka" v grafu. Má popis, který říká v jaké jste situaci a možnosti, přes které se dostanete do další situace.
    Situace má metodu execute, která vypíše popis situace, používá ji třída Controller, která řídi input output
    Potomci situace mají v této metodě interakci se třídou hráč.

    ""
     */
    public String description;
    public ArrayList<Choice> choices;

    Situation(String description, ArrayList<Choice> choices) {
        this.description = description;
        this.choices = choices;
    }

    public String getDescription() { return this.description; }
    public void setDescription(String description){
        this.description = description;
    }

    public void execute(){
        System.out.println(this.getDescription() + "\n");
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
