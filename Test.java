
import java.io.*;
import java.util.Scanner;

// By implementing Serializable interface
// we make sure that state of instances of class DogStepTracker
// can be saved in a file.
class CharacterSheet implements Serializable {
    private static final long serialVersionUID = 1L;
    
    int experience;
    String char_name;
    String char_class;
    String player_name;

    // DogStepTracker class constructor
    public CharacterSheet(int experience, String char_name, String char_class, String player_name) {
        this.experience = experience;
        this.char_name = char_name;
        this.char_class = char_class;
        this.player_name = player_name;
    }
}

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO: get all the info

        /*
        int steps = 100;
        String dogName = "Esther";
        String dogBreed = "Lab Mix";
        String owner = "norrisa";
        */
        // Ask the User to type the info
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter experience points: ");
        int experience = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter the character's name: ");
        String char_name = scanner.nextLine();

        System.out.print("Enter the character's class: ");
        String char_class = scanner.nextLine();

        System.out.print("Enter the player's name: ");
        String player_name = scanner.nextLine();
        // cleanup
        scanner.close();

        // Make the object
        CharacterSheet tracker = new CharacterSheet(experience, char_name, char_class, player_name);
        // Write it to a file
        System.out.println("Writing file...");
        // Serializing 'tracker'
        FileOutputStream fos = new FileOutputStream("char_sheet.data");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(tracker);

        // De-serializing 'tracker'
        FileInputStream fis = new FileInputStream("char_sheet.data");
        ObjectInputStream ois = new ObjectInputStream(fis);
        CharacterSheet deserializedTracker = (CharacterSheet) ois.readObject(); // down-casting object
        System.out.println("Reading file...");
        System.out.println("Character Name: " + deserializedTracker.char_name + ", Experience: " + deserializedTracker.experience);
        System.out.println("Character Class: " + deserializedTracker.char_class);
        System.out.println("Player Name: " + deserializedTracker.player_name);
        // TODO: print all the other data 
        // closing streams
        oos.close();
        ois.close();
    }
}