import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PalindromeTest {

    Palindrome p;

    @BeforeAll
    void beforeAll(){
        p = new Palindrome();
    }

    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "madam", "arun"})
    public void testIsPalindrome(String s){
        Assertions.assertTrue(p.isPalindrome(s));
    }
}
