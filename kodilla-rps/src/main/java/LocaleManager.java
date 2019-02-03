import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleManager {

    private Locale locale;
    public static ResourceBundle messages;

    public void getLocalFromUser(){
        Scanner scanner = new Scanner(System.in);
        boolean isLanguageCorrect = false;

        while(!isLanguageCorrect) {

            System.out.println("Wybierz jezyk polski: p");
            System.out.println("Choose an english: e");
            System.out.println("Selezioni italiano: i");

            String userLanguage = scanner.next();
            switch (userLanguage) {
                case "p":
                    locale = new Locale("pl");
                    isLanguageCorrect = true;
                    break;
                case "e":
                    locale = new Locale("en");
                    isLanguageCorrect = true;
                    break;
                case "i" :
                    locale = new Locale("it");
                    isLanguageCorrect = true;
                    break;
                default :
                    System.out.println("Niepoprawny jezyk/Incorect language/Lingua incorecta");
            }
        }
        messages = ResourceBundle.getBundle("MessagesBundle", locale );
    }

}
