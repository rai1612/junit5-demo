import org.junit.jupiter.api.*;

import java.util.logging.Logger;

public class RepeatedTestsDemo {

    private static final Logger logger = Logger.getLogger(RepeatedTestsDemo.class.getName());

    @BeforeEach
    void init(TestInfo testInfo, RepetitionInfo repetitionInfo){
        int curRepetition = repetitionInfo.getCurrentRepetition();
        int totalRepetition = repetitionInfo.getTotalRepetitions();
        String methodName = testInfo.getTestMethod().get().getName();

        logger.info(String.format("Executing %d of %d for %s", curRepetition, totalRepetition, methodName));

    }
    @RepeatedTest(5)
    void test(){
    }

    @DisplayName("RepeatTest")
    @RepeatedTest(value = 1, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    void customDisplayName(TestInfo testInfo){
        Assertions.assertEquals("RepeatTest 1/1", testInfo.getDisplayName());
    }

}
