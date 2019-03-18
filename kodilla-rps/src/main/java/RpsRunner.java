import java.util.Scanner;

public class RpsRunner {

    public static void main(String[] args) {


        LocaleManager localeManager = new LocaleManager();
        GameInit gameInit = new GameInit();
        localeManager.getLocalFromUser();

        User user = new User(gameInit.getUserName());
        int roundsNumber = gameInit.getRoundsNumber();

        GameSettings gameSettings = new GameSettings(user.getUserName(), roundsNumber);

        GameStatistics gameStatistics = new GameStatistics();
        GameProcessor gameProcessor = new GameProcessor(gameSettings);
        gameProcessor.process();



    }
}
