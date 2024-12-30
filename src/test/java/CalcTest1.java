import org.junit.jupiter.api.*;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(value = CalcTest1.CustomDisplayNameGenerator.class)
public class CalcTest1 {

    CalcTest1(){
        System.out.println("CalcTest constructor");
    }

    private static Calc c;

    @BeforeAll
    static void beforeAll(){
        c = new Calc();
        System.out.println("run before all the test only once");
    }
    @BeforeEach
    void init(){
        System.out.println("run before each test");
    }
    @Test
    public void test_addition_of_two_numbers(){
        int actual = c.add(5, 2);
        int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void test_subtraction_of_two_numbers(){
        int actual = c.subtract(10, 2);
        int expected = 8;
        assertEquals(expected, actual);
    }
    @AfterEach
    void destroy(){
        System.out.println("run after each test");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("run after all the test only once");
    }

    static class CustomDisplayNameGenerator extends DisplayNameGenerator.ReplaceUnderscores{

        @Override
        public String generateDisplayNameForClass(Class<?> testClass) {
            return "Test cases for " + testClass.getName();
        }

        @Override
        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            return super.generateDisplayNameForNestedClass(nestedClass);
        }

        @Override
        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            String name = testClass.getSimpleName() + " " + testMethod.getName();
            return name.replace('_', ' ');
        }
    }
}
