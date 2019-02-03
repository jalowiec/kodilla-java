import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;

public class RpsRunner {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        GameStatistics gameStatistics = new GameStatistics();
        LocaleManager localeManager = new LocaleManager();
        GameInit gameInit = new GameInit();


        localeManager.getLocalFromUser();
        User user = new User(gameInit.getUserName());
        int roundsNumber = gameInit.getRoundsNumber();
        boolean endGame = false;
        while (!endGame) {
            RoundExecutor roundExecutor = new RoundExecutor(gameStatistics);
            roundExecutor.prepareRound();
            roundExecutor.executeRound();
            roundExecutor.finishRound();
            if (gameStatistics.getWins() == roundsNumber) {
                endGame = true;
            }
        }
        RpsRunner.scanner.close();
    }
}
