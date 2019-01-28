import java.util.Scanner;

public class RpsRunner {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        GameMessenger gameMessenger = new GameMessenger();
        GameStatistics gameStatistics = new GameStatistics();
        RoundExecutor roundExecutor = new RoundExecutor();

        gameMessenger.nameAsk();
        String userName = sc.next();
        User user = new User(userName);

        gameMessenger.roundNumberAsk();
        int allRoundsNumber = sc.nextInt();
        // TODO obsluga jak ktos nie poda liczby albo poda ujemna

        gameMessenger.gameRules();

        int roundWinsNumber = 0;
        boolean end = false;

        while (!end) {
            roundWinsNumber++;
            roundExecutor.executeRound();
            if(roundExecutor.isUserWon()){
                gameStatistics.incrementUserWins();
                gameMessenger.roundUserWin();
            }else{
                gameStatistics.incrementComputerWins();
                gameMessenger.roundComputerWIn();
            }
            int userWinsNumber = gameStatistics.getUserWins();
            int computerWinsNumber = gameStatistics.getComputerWins();
            gameMessenger.showGameStatistic(userWinsNumber, computerWinsNumber);

            if (roundWinsNumber == allRoundsNumber) {
                end = true;
            }
        }
        sc.close();

    }


}
