import java.io.*;
import java.util.ArrayList;

public class FileManager implements Serializable{
    /*
    Třída která se stará o ukládání a nahrávní uložených her. Hra se ukládá do složky ve které je src.
    Hru je možné uložit, vypnout a po zapnutí znovu nahrát.

    Class that is working with files. Saving and loading the game. The game state is saved in the project dir.
     */
    Player player;

    FileManager(Player player) throws IOException {
        this.player = player;
    }

    public void saveTheGame() throws IOException {
        FileOutputStream fos = new FileOutputStream("saveFile.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(player);
        oos.close();
        System.out.println("\nGame has been saved successfully. \n");
    }


    public void loadTheGame() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("saveFile.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Player newPlayer = (Player) ois.readObject();
        ois.close();
        this.player.loadSave(newPlayer);

    }


}
