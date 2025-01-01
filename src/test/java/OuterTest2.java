import org.junit.jupiter.api.*;

public class OuterTest2 {

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
    class InnerTest{
        @BeforeAll
        static void initi(){
            System.out.println("Inner class initialised...");
        }
        @AfterAll
        static void destroyi(){
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
