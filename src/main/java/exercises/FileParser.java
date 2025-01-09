package exercises;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {
    public static void main(String[] agrs) throws IOException {

        File file = new File("file.txt");

        if (!file.isFile()) {
            throw new IllegalArgumentException(file.getAbsolutePath() + " is not a file or doesn't exist.");
        }

        // citanie po znakoch
        try (FileReader fr = new FileReader(file)) { // try catch with resources
            int ch;
            StringBuilder word = new StringBuilder();
            int wsCounter = -1;


            while ((ch = fr.read()) != -1) {
                if (!isWhitespace(ch)) {
                    word.append((char) ch);
                    wsCounter = 0;
                } else {
                    if (wsCounter == 0) {
                        System.out.println(word);
                        word = new StringBuilder();
                        wsCounter++;
                    }
                }
            }
        }
    }

    static boolean isWhitespace(int ch) {
        return ch == 32 || ch == 9 || ch == 10 || ch == 13;
    }
}