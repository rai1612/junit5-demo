import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import static org.junit.jupiter.api.Assertions.assertEquals;

// test instance describes the behaviour of TestClass object creation
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalcTest3 {

    CalcTest3(){
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
    @EnabledIfEnvironmentVariable(matches = "staging-service", named = "ENV")
    public void testAdd(){
        int actual = c.add(5, 2);
        int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    @DisabledIfEnvironmentVariable(matches = "staging-service", named = "ENV")
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
