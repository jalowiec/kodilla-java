public class GameSettings {

    private final String userName;
    private final int roundNumber;

    public GameSettings(String userName, int roundNumber) {
        this.userName = userName;
        this.roundNumber = roundNumber;
    }

    public int getRoundNumber() {
        return roundNumber;
    }
}
