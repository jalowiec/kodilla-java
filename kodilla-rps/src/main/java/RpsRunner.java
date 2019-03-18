public class RpsRunner {

    public static void main(String[] args) {


        LocaleManager localeManager = new LocaleManager();
        localeManager.getLocalFromUser();

        GameInit gameInit = new GameInit();
        User user = new User(gameInit.getUserName());
        int roundsNumber = gameInit.getRoundsNumber();

        GameSettings gameSettings = new GameSettings(user.getUserName(), roundsNumber);
        GameProcessor gameProcessor = new GameProcessor(gameSettings);
        gameProcessor.process();



    }
}
