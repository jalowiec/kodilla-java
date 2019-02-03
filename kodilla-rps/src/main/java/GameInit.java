import java.util.InputMismatchException;
import java.util.Scanner;

public class GameInit {

    public String getUserName() {
        System.out.println(LocaleManager.messages.getString("ask for name"));
        return RpsRunner.scanner.next();
    }

    public int getRoundsNumber() {
        boolean isRoundsNumberCorrect = false;
        int userRoundsNumber = 0;
        while (!isRoundsNumberCorrect) {
            System.out.println(LocaleManager.messages.getString("ask for round number"));
            try{
                userRoundsNumber = RpsRunner.scanner.nextInt();
                if(userRoundsNumber > 0 && userRoundsNumber < 11){
                    isRoundsNumberCorrect = true;
                }else{
                    System.out.println(LocaleManager.messages.getString("wrong range round number"));
                }
            }
            catch (InputMismatchException e) {
                System.out.println(LocaleManager.messages.getString("wrong number format"));
                String inputMismatchNumber = RpsRunner.scanner.next();
            }
        }
        return userRoundsNumber;
    }
}





