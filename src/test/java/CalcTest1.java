import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

import static org.junit.jupiter.api.Assertions.assertEquals;

// test instance describes the behaviour of TestClass object creation
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@EnabledOnJre(value = {JRE.JAVA_17, JRE.JAVA_8, JRE.JAVA_11})
public class CalcTest1 {

    CalcTest1(){
        System.out.println("CalcTest constructor");
    }

    Calc c;

    @BeforeAll
    void beforeAll(){
        c = new Calc();
        System.out.println("run before all the test only once");
    }
    @BeforeEach
    void init(){
        System.out.println("run before each test");
    }
    @Test
    @EnabledOnJre(value = {JRE.JAVA_17})
    public void testAdd(){
        int actual = c.add(5, 2);
        int expected = 7;
        assertEquals(expected, actual);
    }
    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_21)
    public void testAdd1(){
        int actual = c.add(5, 2);
        int expected = 7;
        assertEquals(expected, actual);
    }
    @Test
    @DisabledOnJre(value = {JRE.JAVA_17})
    public void testSubtract(){
        int actual = c.subtract(10, 2);
        int expected = 8;
        assertEquals(expected, actual);
    }
    @AfterEach
    void destroy(){
        System.out.println("run after each test");
    }

    @AfterAll
    void afterAll(){
        System.out.println("run after all the test only once");
    }
}
