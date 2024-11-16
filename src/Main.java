import java.util.Scanner;
import java.io.File;
import java.util.HashSet;

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
                    String result = handleString(action, text);
                    System.out.println("Text: [" + text + "] ran Action: [" + action + "] with result [" + result + "]"); // Utskrift i henhold til eksemplet i oppgaven
                } else {
                    System.out.println("Invalid line: " + data); // Feilhåndtering
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public static String handleString(String action, String text) {
        switch (action) {
            case "PALINDROME": // true hvis ordet er et palindrom, ellers false
                return String.valueOf(isPalindrome(text)); // "Konverterer" boolean til String
            case "WHITESPACE": // Fjerner alle mellomrom
                return removeWhitespace(text);
            case "REVERSE": // Reverserer teksten
                return reverseText(text);
            case "UNIQUE_COUNT": // Teller antall unike karakterer i ordet
                return String.valueOf(uniqueCount(text)); // "Konverterer" int til String
            case "CAPITALIZE": // Setter stor forbokstav på ordet
                return doCapitalize(text);
            default:
                return "Couldn't find Action.";
        }
    }

    public static boolean isPalindrome(String text) {
        String reversedText = new StringBuilder(text).reverse().toString();
        return reversedText.equals(text); // Denne returnerer true eller false basert på om ordet er et palindrom
    }

    public static String removeWhitespace(String text) {
        String cleanString = text.replaceAll("\\s+", ""); // \\s+ er regex for mellomrom
        return cleanString;
    }

    public static String reverseText(String text) {
        String reversedString = new StringBuilder(text).reverse().toString();
        return reversedString;
    }

    public static int uniqueCount(String text) {
        HashSet<String> word = new HashSet<>(); // HashSet holder bare på unike verdier
        for (int i = 0; i < text.length(); i++) {
            word.add(String.valueOf(text.charAt(i))); // Legger til en bokstav for hver iterasjon, antall iterasjoner er lik antall bokstaver i ordet
        }

        return word.size();
    }

    public static String doCapitalize(String text) {
        String capitalizedText = text.substring(0,1).toUpperCase() + text.substring(1); // Deler opp ordet i to subStrings, for første subString bare er første bokstav.
        return capitalizedText;
    }

}
