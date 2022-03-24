import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterCounterTest {

    @Test
    public void testValidWords() {
        assertTrue(CharacterCounter.validateWord("?!?!?!"));
        assertTrue(CharacterCounter.validateWord("abcabc"));
        assertTrue(CharacterCounter.validateWord("AbcaBc"));
        assertTrue(CharacterCounter.validateWord("AbcCBa"));
        assertTrue(CharacterCounter.validateWord("abc123"));
        assertTrue(CharacterCounter.validateWord("abc!abc!"));
    }

    @Test
    public void testInvalidWords() {
        assertFalse(CharacterCounter.validateWord("AbcabcC"));
        assertFalse(CharacterCounter.validateWord("piappi"));
        assertFalse(CharacterCounter.validateWord("abcabcd"));
        assertFalse(CharacterCounter.validateWord("?abc:abc"));
    }
}