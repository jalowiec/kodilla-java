public class GameRules {

    public boolean isDraw(Enum userChoice, Enum computerChoice){

        if(userChoice == computerChoice){
            return true;
        }
        return false;
    }

    public boolean isUserWin(Enum userChoice, Enum computerChoice){

        if(userChoice == GameChoice.R && computerChoice == GameChoice.S){
            return true;
        }
        if(userChoice == GameChoice.P && computerChoice == GameChoice.R){
            return true;
        }
        if(userChoice == GameChoice.S && computerChoice == GameChoice.P){
            return true;
        }
        return false;
    }
}
