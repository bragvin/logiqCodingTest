import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {

        File file = new File("actiontexts.txt");
        
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
