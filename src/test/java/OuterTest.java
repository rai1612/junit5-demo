import org.junit.jupiter.api.*;

public class OuterTest {

    @BeforeAll
    static void init(){
        System.out.println("Outer class initialized...");
    }

    @AfterAll
    static void destroy(){
        System.out.println("Outer class destroyed...");
    }

    @Test
    void outerTest1(){
        System.out.println("Outer test 1");
    }

    @Test
    void outerTest2(){
        System.out.println("Outer test 2");
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class InnerTest{
        @BeforeAll
        void initi(){
            System.out.println("Inner class initialised...");
        }
        @AfterAll
        void destroyi(){
            System.out.println("Inner class destroyed...");
        }
        @Test
        void innerTest1(){
            System.out.println("Inner test 1");
        }
        @Test
        void innerTest2(){
            System.out.println("Inner test 2");
        }
    }
}
