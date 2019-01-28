import java.util.Scanner;

public class RoundExecutor {

    private boolean isUserWon=false;

    public boolean isUserWon() {
        return isUserWon;
    }

    public void executeRound(){

        GameMessenger gameMessenger = new GameMessenger();
        UserChoiceParser ucp = new UserChoiceParser();
        Scanner sc = new Scanner(System.in);
        RandomChoice randomChoice = new RandomChoice();
        KeyTranslator keyTranslator = new KeyTranslator();
        GameRules gameRules = new GameRules();

        boolean roundEnd = false;

        while(!roundEnd){
            gameMessenger.gameNextMove();
            String userChoice = sc.next();
            while (!ucp.roundUserChoiceCorrect(userChoice)) {
                gameMessenger.gameNextMove();
                userChoice = sc.next();
            }
            String computerChoice = randomChoice.getRandomChoice();

            gameMessenger.userTranslatedChoice(keyTranslator.tranlateKey(userChoice));
            gameMessenger.computerTranslatedChoice(keyTranslator.tranlateKey(computerChoice));

            if(!gameRules.isDraw(userChoice, computerChoice)){
                roundEnd = true;
                if(gameRules.isUserWin(keyTranslator.tranlateKey(userChoice), keyTranslator.tranlateKey(computerChoice))){
                    isUserWon = true;
                }
            }else {
                gameMessenger.roundDraw();
            }
        }
    }
}
