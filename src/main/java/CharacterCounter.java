import java.util.Locale;

public class CharacterCounter {

    public static boolean validateWord(String word) {
        char[] wordArray = word.toLowerCase().toCharArray();
        for (char letter : wordArray) {
            long occurrence = word.chars().filter(ch -> ch == letter).count();
        }
        return false;
    }
}