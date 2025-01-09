package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlockAligner {
        
    public static void main(String[] agrs) throws IOException {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) { // try catch with resources
            
            int lineWidth = getWidth(reader);
            String inputText = prepareText(reader);
            processText(lineWidth, inputText);
        }
    }

    public static int getWidth(BufferedReader reader) throws IOException {
        String firstLine = reader.readLine();
        return Integer.parseInt(firstLine); // pocet znakov v jednom riadku
    }

    public static String prepareText(BufferedReader reader) throws IOException {

        StringBuilder inputText = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null && !line.isEmpty()) {
            inputText.append(line).append(" ");
        }
        return inputText.toString();
    }

    public static void processText(int lineWidth, String text) {

        String[] words = getWords(text);
        StringBuilder line = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (line.length() == 0) { // prazdy riadok
                if (words[i].length() <= lineWidth) { // nove slovo sa zmesti do riadku
                    line.append(words[i]);
                } else { // nove slovo sa nezmesti do riadku
                    System.out.println(words[i]);
                } 
            } else { // uz mam nieco v riadku
                if (line.length() + 1 + words[i].length() <= lineWidth) { // medzera s novym slovom sa zmestia na riadok
                    line.append(" " + words[i]);
                } else { // medzera s novym slovom sa na riadok nezmestia
                    line = processLine(lineWidth, line); // TODO
                    System.out.println(line);
                    line.delete(0, line.length());
                    line.append(words[i]);
                }
            }
        }
        if (line.length() != 0) {
            System.out.println(line); //  vypisanie posledneho riadku xd
        }
    }

    public static String[] getWords(String text) {
        String[] words = text.split("\\s+");
        return words;
    }

    public static StringBuilder processLine(int lineWidth, StringBuilder line) {
        String[] words = getWords(line.toString());
        int noOfSpaces = words.length - 1; // tolko medzier
        int toInsert = lineWidth - line.length() + noOfSpaces; 
        
        int everywhere = toInsert / noOfSpaces; 
        int oneSpace = toInsert % noOfSpaces;

        return line;
    }
}