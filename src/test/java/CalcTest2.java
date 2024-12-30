import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import static org.junit.jupiter.api.Assertions.assertEquals;

// test instance describes the behaviour of TestClass object creation
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalcTest2 {

    CalcTest2(){
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
    @EnabledIfSystemProperty(named = "java.vm.vendor", matches = "Ubuntu")
    public void testAdd(){
        int actual = c.add(5, 2);
        int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    @DisabledIfSystemProperty(named = "java.vm.vendor", matches = "Ubuntu")
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
