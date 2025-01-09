package cz.cuni.mff.milotovl.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileUtils {

    private static final ExecutorService executorService = Executors.newSingleThreadExecutor(); // executor na task hladania najdlhsieho slova
    public static Future<String> longestWordInFile(String filepath) {
        CompletableFuture<String> future = new CompletableFuture<>(); // tato premenna bude drzat finalny vysledok pocitany asynchronne, wrapped Future<String>
        executorService.submit(() -> { // executoru davame asynchronny task definovany lambda vyrazom
            try {
                String longestWord = findLongestWord(filepath); // hladanie najdlhsieho slova
                future.complete(longestWord); // task je hotovy ked longestWord obsahuje vysledok
            } catch (IOException e) {
                future.completeExceptionally(e); // task hotovy s vynimkou
            }
        });
        return future; // vratime Future<>
    }

    private static String findLongestWord(String filepath) throws IOException {
        if (filepath == null || filepath.isEmpty()) {
            throw new IllegalArgumentException("Filepath nemoze byt prazdny alebo null");
        }

        String longestWord = "";
        StringBuilder currentWord = new StringBuilder();
        int currentChar;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            while ((currentChar = reader.read()) != -1) { // citam subor znak po znaku
                char character = (char) currentChar;

                if (Character.isLetterOrDigit(character)) {
                    currentWord.append(character); // build slova
                } else {
                    if (currentWord.length() > longestWord.length()) {
                        longestWord = currentWord.toString(); // vyber dlhsieho slova
                    }
                    currentWord.setLength(0);
                }
            }

            if (currentWord.length() > longestWord.length()) {
                longestWord = currentWord.toString(); // kontrola dlhsieho slova na konci suboru
            }
            return longestWord;
        }
    }

    public static void main(String[] args) {
        String filepath = "file.txt";
        try {
            String longestWord = findLongestWord(filepath);
            if (longestWord == "") {
                System.out.println("Subor je prazdny");
            } else {
                System.out.println("Longest word is " + findLongestWord(filepath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}