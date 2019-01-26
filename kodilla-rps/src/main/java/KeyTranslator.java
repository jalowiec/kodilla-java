import java.util.HashMap;
import java.util.Map;

public class KeyTranslator {
    public String tranlateKey(String keyChoice){
        Map<String, String> translateMap = new HashMap<>();
        translateMap.put("1", "Kamien");
        translateMap.put("2", "Papier");
        translateMap.put("3", "Nozyce");
        return translateMap.get(keyChoice);
    }
}
