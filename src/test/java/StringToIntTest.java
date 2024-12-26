import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringToIntTest {

    String s;
    @Test
    void testConvertThrowsIllegalArgumentException(){
        s = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> StringToInt.convert(s));
    }
    @Test
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
