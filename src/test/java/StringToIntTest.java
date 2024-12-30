import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(value = "string to integer testing")
public class StringToIntTest {

    String s;
    @Test
    @DisplayName(value = "illegal argument exception test")
    void testConvertThrowsIllegalArgumentException(){
        s = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> StringToInt.convert(s));
    }
    @Test
    @DisplayName(value = "number format exception test")
    void testConvertThrowsNumberFormatException(){
        s = "234sd";
        Assertions.assertThrows(NumberFormatException.class, ()-> StringToInt.convert(s));
    }
    @Test
    void testConvert(){
        s = "45";
        Assertions.assertDoesNotThrow(()-> StringToInt.convert(s));
    }
}
