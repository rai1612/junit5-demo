import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class SharedTempDirectoryTest {

    @TempDir
    static Path sharedTempDir;

    @BeforeAll
    static void init(){
        System.out.println(sharedTempDir);
    }

    @AfterAll
    static void destroy(@TempDir Path path){
        System.out.println(path);
    }
    @Test
    void testWithTempDir(@TempDir Path tempDir) throws IOException {
        Path numbersPath = tempDir.resolve("numberstest.txt");

        List<String> list = Arrays.asList("100, 200, 300, 400, 500");
        Files.write(numbersPath, list);

        Assertions.assertAll(
                () -> Assertions.assertTrue(Files.exists(numbersPath), "File should exist"),
                () -> Assertions.assertLinesMatch(list, Files.readAllLines(numbersPath))
        );
    }

    @Test
    void testAsSharedTempDir1() throws IOException {

        Path numbersPath = sharedTempDir.resolve("numberstest.txt");

        List<String> list = Arrays.asList("100, 200, 300, 400, 500");
        Files.write(numbersPath, list);

        Assertions.assertAll(
                () -> Assertions.assertTrue(Files.exists(numbersPath), "File should exist"),
                () -> Assertions.assertLinesMatch(list, Files.readAllLines(numbersPath))
        );

    }
}
