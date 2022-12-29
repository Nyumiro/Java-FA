import java.util.*;

public class FrequencyDictionary {
    private static String[] toWords(String text){
        return text.toLowerCase().split("[—–,!?;:\\s().^0-9\\n\\r]");
    }
    public static Map<String, Integer> get(String text) {
        var array_text = toWords(text);
        var frequency_dictionary = new HashMap<String, Integer>();
        for (var word : array_text) {
            if (Objects.equals(word, ""))
                continue;
            if (frequency_dictionary.containsKey(word))
                frequency_dictionary.put(word, frequency_dictionary.get(word) + 1);
            else
                frequency_dictionary.put(word, 1);
        }
        return frequency_dictionary;
    }
}
