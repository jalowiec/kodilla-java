import java.util.HashMap;
import java.util.Map;

public class KeyTranslator {
    public Enum translateKeyToGameChoice(String keyChoice){
        Map<String, Enum> translateMap = new HashMap<>();
        translateMap.put("1", GameChoice.R);
        translateMap.put("2", GameChoice.P);
        translateMap.put("3", GameChoice.S);
        return translateMap.get(keyChoice);
    }

    public String translateKeytoChoiceName(String keyChoice){
        Map<String, String> translateMap = new HashMap<>();
        translateMap.put("1", "rock");
        translateMap.put("2", "paper");
        translateMap.put("3", "scissors");
        return translateMap.get(keyChoice);
    }
    //TODO - obsluga nulla


}
