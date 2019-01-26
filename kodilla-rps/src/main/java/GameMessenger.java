public class GameMessenger {

    public void gameRules(){
        System.out.println("Zasady gry");
        System.out.println("1 - kamien");
        System.out.println("2 - papier");
        System.out.println("3 - nozyce");
        System.out.println("x - zakonczenie gry");
        System.out.println("n - nowa gra");

    }
    public void nameAsk(){
        System.out.println("Podaj imie: ");
    }

    public void roundNumberAsk(){
        System.out.println("Podaj liczbe wygranych rund: ");
    }

    public void gameNextMove(int roundNumber, int allRoundNumber){
        System.out.println("Runda " + roundNumber + " z " + allRoundNumber + ". Wybierz ruch: ");
    }

    public void userTranslatedChoice (String translatedChoice){
        System.out.println("Wybrales: " + translatedChoice);
    }

    public void computerTranslatedChoice (String translatedChoice){
        System.out.println("Komputer wybral: " + translatedChoice);
    }

    public void confirmationEndGame(){
        System.out.println("Czy na pewno zakonczyc gre?");
    }

    public void confirmationNewGame(){
        System.out.println("Czy na pewno zakonczyc aktualna gre?");
    }

    public void gameStatistic(){
        System.out.println("Statystyki:");
    }


}
