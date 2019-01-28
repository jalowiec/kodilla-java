public class GameRules {

    public boolean isDraw(String userChoice, String computerChoice){

        if(userChoice.equals(computerChoice)){
            return true;
        }
        return false;
    }

    public boolean isUserWin(String userChoice, String computerChoice){

        if(userChoice.equals("Kamien") && computerChoice.equals("Nozyce")){
            return true;
        }
        if(userChoice.equals("Papier") && computerChoice.equals("Kamien")){
            return true;
        }
        if(userChoice.equals("Nozyce") && computerChoice.equals("Papier")){
            return true;
        }

        return false;
    }
}
