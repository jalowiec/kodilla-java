public class GameStatistics {

    int userWins;
    int computerWins;

    public int getUserWins() {
        return userWins;
    }

    public int getComputerWins() {
        return computerWins;
    }

    public int getWins(){
        if(userWins > computerWins){
            return userWins;
        }else{
            return computerWins;
        }
    }

    public void incrementUserWins() {
        userWins++;
    }

    public void incrementComputerWins() {
        computerWins++;
    }



}
