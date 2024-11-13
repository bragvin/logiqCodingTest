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
                System.out.println(data);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
