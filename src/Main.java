import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {

        File file = new File("actiontexts.txt");
        
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();       // Leser neste linje
                String[] parts = data.split(":"); // Deler opp linjen i to deler hvor ":" er skillet
                if (parts.length == 2) {
                    String action = parts[0];
                    String text = parts[1];
                    System.out.println("Text: [" + text + "] ran action [" + action + "] with result [" + text + "]");
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
