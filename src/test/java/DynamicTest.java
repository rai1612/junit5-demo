import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class DynamicTest {

    static private Palindrome palindrome;
    static private Calc calc;

    @BeforeAll
    static void init() {
        palindrome = new Palindrome();
        calc = new Calc();
        System.out.println("Starting testing...");
    }

    @AfterAll
    static void destroy() {
        palindrome = null;
        calc = null;
        System.out.println("Ending testing...");
    }

    //    @TestFactory
//    List<String> dynamicTestWithInvalidReturnType(){
//        return Arrays.asList("Arun Kumar Rai");
//    }
    @TestFactory
    Stream<org.junit.jupiter.api.DynamicTest> dynamicTestForPalindrome() {
        return Stream.of("pop", "madam", "mom", "dad", "radar", "racecar")
                .map(input -> dynamicTest(input, () -> assertTrue(palindrome.isPalindrome(input))));
    }

    @TestFactory
    DynamicNode dynamicTestOfSingleDynamicNode() {
        return dynamicTest("palindrome check for mom", () -> palindrome.isPalindrome("mom"));
    }

    @TestFactory
    DynamicNode dynamicTestFromSingleNodeContainer() {
        return dynamicContainer("palindromes", Stream.of("pop", "dad").map(input -> dynamicTest(input, () -> assertTrue(palindrome.isPalindrome(input)))));
    }

    @TestFactory
    Collection<org.junit.jupiter.api.DynamicTest> dynamicTestsFromCollection() {

        return Arrays.asList(
                dynamicTest("dynamic-test-1", () -> assertTrue(palindrome.isPalindrome("radar"))),
                dynamicTest("dynamic-test-2", () -> assertEquals(10, calc.add(5, 5))))
                ;
    }

    @TestFactory
    Stream<DynamicNode> dynamicTestWithContainers() {
        return Stream.of("A", "B", "C")
                .map(input -> dynamicContainer("Container " + input, Stream.of(dynamicTest("not null", () -> assertNotNull(input)),
                        dynamicContainer("properties", Stream.of(dynamicTest("length > 0", () -> assertTrue(input.length() > 0)),
                                dynamicTest("not empty", () -> assertFalse(input.isEmpty())))))));
    }


    @TestFactory
    Stream<org.junit.jupiter.api.DynamicTest> dynamicTestFromIntStream(){
        return IntStream.iterate(0, n->n+2).limit(5)
                .mapToObj(n -> dynamicTest("test"+n, ()->assertTrue(n%2 == 0)));
    }

    @TestFactory
    Iterable<org.junit.jupiter.api.DynamicTest> dynamicTestFromIterable(){
        return Arrays.asList(
                dynamicTest("dynamic-test-1", ()->assertTrue(palindrome.isPalindrome("radar")))
                ,
                dynamicTest("dynamic-test-2", ()->assertEquals(50, calc.add(12, 38)))
        );
    }

    @TestFactory
    Iterator<org.junit.jupiter.api.DynamicTest> dynamicTestFromIterator(){
        return Arrays.asList(
                dynamicTest("dynamic-test-1", ()->assertTrue(palindrome.isPalindrome("radar")))
                ,
                dynamicTest("dynamic-test-2", ()->assertEquals(50, calc.add(12, 38)))

        ).iterator();
    }

    @TestFactory
    org.junit.jupiter.api.DynamicTest[] dynamicTestFromArray(){
        return new org.junit.jupiter.api.DynamicTest[]{
                dynamicTest("dynamic-test-1", ()->assertTrue(palindrome.isPalindrome("radar")))
                ,
                dynamicTest("dynamic-test-2", ()->assertEquals(50, calc.add(12, 38)))
        };
    }
            
}
