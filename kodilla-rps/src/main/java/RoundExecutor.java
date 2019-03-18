public class RoundExecutor {

    private boolean isUserWon = false;
    private GameSettings gameSettings;
    private GameStatistics gameStatistics;
    private ScannerSingleton scannerSingleton = ScannerSingleton.getInstance();

    public RoundExecutor(GameSettings gameSettings, GameStatistics gameStatistics) {
        this.gameSettings = gameSettings;
        this.gameStatistics = gameStatistics;
    }

    public void prepareRound() {
        System.out.println(LocaleManager.messages.getString("game rules info"));
    }


    public void executeRound() {

        UserChoiceParser ucp = new UserChoiceParser();
        RandomChoice randomChoice = new RandomChoice();
        KeyTranslator keyTranslator = new KeyTranslator();
        GameRules gameRules = new GameRules();
        GameHolder gameHolder = new GameHolder();

        boolean roundEnd = false;

        while (!roundEnd) {
            System.out.println(LocaleManager.messages.getString("make a move"));
            String userChoice = scannerSingleton.next();
            String computerChoice = randomChoice.getRandomChoice();
            if (ucp.roundUserChoiceCorrect(userChoice)) {
                if(ucp.continueGame(userChoice)) {
                    System.out.println(LocaleManager.messages.getString("user move") +
                            LocaleManager.messages.getString(keyTranslator.translateKeytoChoiceName(userChoice)));

                    System.out.println(LocaleManager.messages.getString("computer move") +
                            LocaleManager.messages.getString(keyTranslator.translateKeytoChoiceName(computerChoice)));
                } else {
                    gameHolder.processUserChoice(userChoice, gameSettings);
                }
                if (!gameRules.isDraw(keyTranslator.translateKeyToGameChoice(userChoice), keyTranslator.translateKeyToGameChoice(computerChoice))) {
                    roundEnd = true;
                } else {
                    System.out.println(LocaleManager.messages.getString("draw"));
                }
            } else {
                System.out.println(LocaleManager.messages.getString("incorrect move"));
            }

            if (gameRules.isUserWin(keyTranslator.translateKeyToGameChoice(userChoice), keyTranslator.translateKeyToGameChoice(computerChoice))) {
                isUserWon = true;

            }
        }
    }
    public void finishRound(){
        if(isUserWon){
            gameStatistics.incrementUserWins();
        }else{
            gameStatistics.incrementComputerWins();
        }
        System.out.println("-------------------------------------------");
        System.out.println(LocaleManager.messages.getString("user win numbers") + " " + gameStatistics.getUserWins());
        System.out.println(LocaleManager.messages.getString("computer win numbers") + " " + gameStatistics.getComputerWins());
        System.out.println("-------------------------------------------");

    }

}
