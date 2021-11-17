import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        Player player = new Player(); //for references, we haven't initilize

        //items
        Item sword = new Item("Excalibur", "Excalibur is the legendary sword of King Arthur.");

        //end,win of the game
        SituationWin win = new SituationWin("Congratulation you won");
        ArrayList<Choice> gameoverChoices = new ArrayList<>(){};
        Situation gameOver = new Situation("Game over", gameoverChoices);


        //lists of choices for difference situations
        ArrayList<Choice> startChoices = new ArrayList<>();
        ArrayList<Choice> crossroadsChoices = new ArrayList<>();
        ArrayList<Choice> swordInChoices = new ArrayList<>();
        ArrayList<Choice> swordPuzzleChoices = new ArrayList<>();
        ArrayList<Choice> swordOutChoices = new ArrayList<>();
        ArrayList<Choice> chasmChoices = new ArrayList<>();
        ArrayList<Choice> dragonChoices = new ArrayList<>();
        ArrayList<Choice> dragonWithSwordChoices = new ArrayList<>();
        ArrayList<Choice> treasureChoices = new ArrayList<>();

        //situations initialization
        Situation start = new Situation("", startChoices);
        Situation crossroads = new Situation("", crossroadsChoices);
        Situation swordIn = new Situation("", swordInChoices);
        Situation swordPuzzle = new Situation("Riddle me this: What is the worst case of Quicksort?", swordPuzzleChoices);
        SituationAddItem swordOut = new SituationAddItem("You've managed to pick up the swordl.", swordOutChoices, player, sword);
        Situation chasm = new Situation("", chasmChoices);
        Situation dragon = new Situation("", dragonChoices);
        SituationTakeDamage dragonNoSword = new SituationTakeDamage("You challenged the dragon in hand-to-hand combat.", gameoverChoices, player, 10 );
        SituationTakeDamage dragonWithSword = new SituationTakeDamage("Good thing you found that sword, after furious fight you stand victorious. \nNow treasure is yours.", null, player, 9);
        Situation treasure = new Situation("", treasureChoices);

        //choices for start
        Choice startSit1 = new Choice("Go back to town", gameOver);
        Choice startSit2 = new Choice("Go into the cave", crossroads);
        startChoices.add(startSit1);
        startChoices.add(startSit2);

        //choices for end
        Choice end1 = new Choice("Restart", start);
        Choice end2 = new Choice("Exit", null);
        gameoverChoices.add(end1);
        gameoverChoices.add(end2);

        //choices for crossroads
        Choice crossroads1 = new Choice("Go left", swordIn);
        Choice crossroads2 = new Choice("Go forward", chasm);
        Choice crossroads3 = new Choice("Go right", dragon);
        Choice crossroads4 = new Choice("Go back", crossroads);
        crossroadsChoices.add(crossroads1);
        crossroadsChoices.add(crossroads2);
        crossroadsChoices.add(crossroads3);
        crossroadsChoices.add(crossroads4);

        //choices for swordIn
        Choice swordIn1 = new Choice("Try to pick up the sowrd", swordPuzzle);
        Choice swordIn2 = new Choice("Go back", crossroads);
        swordInChoices.add(swordIn1);
        swordInChoices.add(swordIn2);

        //choices for swordPuzzle
        Choice swordPuzzle1 = new Choice("n log n", swordPuzzle);
        Choice swordPuzzle2 = new Choice("2^n ", swordPuzzle);
        Choice swordPuzzle3 = new Choice("log n", swordPuzzle);
        Choice swordPuzzle4 = new Choice("n^2", swordOut);
        swordPuzzleChoices.add(swordPuzzle1);
        swordPuzzleChoices.add(swordPuzzle2);
        swordPuzzleChoices.add(swordPuzzle3);
        swordPuzzleChoices.add(swordPuzzle4);

        //choices for swordOut
        Choice swordOut1 = new Choice("Go back to the crossing", crossroads);
        swordOutChoices.add(swordOut1);

        //choices for chasm
        Choice chasm1= new Choice("Jump into the chasm", gameOver);
        Choice chasm2 = new Choice("Go back to the crossing", crossroads);
        chasmChoices.add(chasm1);
        chasmChoices.add(chasm2);

        //choices for dragon
        IfChoice dragon1 = new IfChoice("Attack dragon", player.hasItem(sword), dragonWithSword, dragonNoSword);
        Choice dragon2 = new Choice("Go back.",crossroads);
        dragonChoices.add(dragon1);
        dragonChoices.add(dragon2);

        //choices for dragonWithSword
        Choice dragonWithSword1 = new Choice("Get treasure.",win);
        Choice dragonWithSword2 = new Choice("Go back",crossroads);
        dragonWithSwordChoices.add(dragonWithSword1);
        dragonWithSwordChoices.add(dragonWithSword2);

        //final setup of player and save system
        player.setMainSituations(start, gameOver);
        FileManager fileManager = new FileManager(player);
        Controller controller = new Controller(player, fileManager);

        //game start
        controller.gameStart();


//        //first situation initialization
//        Situation start = new Situation("You stand before the cave entrance.", startChoices);
//        //player initialization
//        Player player = new Player(start, gameOver);
//        //file system (load, save)initialization
//        FileManager fileManager = new FileManager(player);
//
//        Choice openOptions = new Choice("Options menu", optionsMenu);
//        Controller controller = new Controller(player,d);




    }
}
