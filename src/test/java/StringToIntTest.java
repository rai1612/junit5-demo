import org.junit.jupiter.api.*;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class StringToIntTest {

    String s;
    @Test
    @Order(value = 2)
    void testConvertThrowsIllegalArgumentException(){
        s = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> StringToInt.convert(s));
    }
    @Test
    @Order(value = 3)
    void testConvertThrowsNumberFormatException(){
        s = "234sd";
        Assertions.assertThrows(NumberFormatException.class, ()-> StringToInt.convert(s));
    }
    @Test
    @Order(value = 1)
    void testConvert(){
        s = "45";
        Assertions.assertDoesNotThrow(()-> StringToInt.convert(s));
    }
}
