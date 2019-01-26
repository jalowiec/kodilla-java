import java.util.Scanner;

public class RpsRunner {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        GameMessenger gameMessenger = new GameMessenger();
        UserChoiceParser ucp = new UserChoiceParser();
        KeyTranslator keyTranslator = new KeyTranslator();
        RandomChoice randomChoice = new RandomChoice();



        gameMessenger.nameAsk();
        String userName = sc.next();
        User user = new User(userName);

        gameMessenger.roundNumberAsk();
        int allRoundsNumber = sc.nextInt();
        // TODO obsluga jak ktos nie poda liczby albo poda ujemna

        gameMessenger.gameRules();

        int roundNumber = 0;
        boolean end = false;

        while (!end) {
            roundNumber++;
            gameMessenger.gameNextMove(roundNumber, allRoundsNumber);
            String userChoice = sc.next();
            while (!ucp.roundUserChoiceCorrect(userChoice)) {
                gameMessenger.gameNextMove(roundNumber, allRoundsNumber);
                userChoice = sc.next();
            }
            gameMessenger.userTranslatedChoice(keyTranslator.tranlateKey(userChoice));
            String computerChoice = randomChoice.getRandomChoice();
            gameMessenger.computerTranslatedChoice(keyTranslator.tranlateKey(computerChoice));


            if (roundNumber == allRoundsNumber) {
                end = true;
            }
        }









    }


}
