public class GameProcessor {


    private GameSettings gameSettings;
    private ScannerSingleton scannerSingleton = ScannerSingleton.getInstance();

    public GameProcessor(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    public void process() {
        GameStatistics gameStatistics = new GameStatistics();
        boolean endGame = false;
        while (!endGame) {
            RoundExecutor roundExecutor = new RoundExecutor(gameSettings, gameStatistics);
            roundExecutor.prepareRound();
            roundExecutor.executeRound();
            roundExecutor.finishRound();
            if (gameStatistics.getWins() == gameSettings.getRoundNumber()) {
                endGame = true;
                scannerSingleton.close();
            }
        }
    }
}
