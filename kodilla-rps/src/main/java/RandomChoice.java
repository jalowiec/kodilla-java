import java.util.Random;

public class RandomChoice {

    public String getRandomChoice(){
        Random random = new Random();
        int randomInt = random.nextInt(2) + 1;
        return Integer.toString(randomInt);
    }
}
