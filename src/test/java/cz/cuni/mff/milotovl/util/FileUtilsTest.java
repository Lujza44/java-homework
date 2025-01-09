package cz.cuni.mff.milotovl.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

public class FileUtilsTest {


    @Test
    public void testComputation() {
        String filepath = "file.txt";
        Future<String> future = FileUtils.longestWordInFile(filepath);
        try {
            String longestWord = future.get();
            assertEquals("aaaaaaaaaaaaaaaaaaaaaaaaaaaa", longestWord);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testException() {
        String filepath = "nonexistingfile.txt";
        Future<String> future = FileUtils.longestWordInFile(filepath);
        try {
            String longestWord = future.get();
        } catch (ExecutionException | InterruptedException e) {
            assertTrue(e.getCause() instanceof java.io.IOException);
        }
    }

    @Test
    public void noWord() {
        String filepath = "file.txt";
        Future<String> future = FileUtils.longestWordInFile(filepath);
        try {
            String longestWord = future.get();
            assertEquals("", longestWord);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
