package rushikapatel_sec001_ex01;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

public class WordTypeCount {
    public static void main(String[] args) {
        // Create HashMap to store words as keys and their counts as values
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Method call to create map based on user input
        createMap(wordCountMap);

        // Method call to display content of the map
        displayMap(wordCountMap);

        // Method call to find and display words with minimum and maximum occurrences
        findMinMaxRepeatedWords(wordCountMap);
    }

    // Method to create map from user input
    private static void createMap(Map<String, Integer> map) {
        Scanner scanner = new Scanner(System.in); // Create scanner for user input
        System.out.println("Enter a string:"); // Prompt user for input
        String input = scanner.nextLine();

        // Tokenize the input string
        String[] tokens = input.split(" ");

        // Process the input text
        for (String token : tokens) {
            String word = token.toLowerCase(); // Convert word to lowercase

            // If the map contains the word
            if (map.containsKey(word)) { // Check if word is in the map
                int count = map.get(word); // Get current count
                map.put(word, count + 1); // Increment count
            } else {
                map.put(word, 1); // Add new word with a count of 1 to map
            }
        }
    }

    // Method to display map content
    private static void displayMap(Map<String, Integer> map) {
        Set<String> keys = map.keySet(); // Get keys

        // Sort keys
        TreeSet<String> sortedKeys = new TreeSet<>(keys);

        System.out.printf("%nMap contains:%nKey\t\tValue%n");

        // Generate output for each key in map
        for (String key : sortedKeys) {
            System.out.printf("%-10s%10s%n", key, map.get(key));
        }

        // Display size and emptiness status of the map
        System.out.printf(
                "%nsize: %d%nisEmpty: %b%n", map.size(), map.isEmpty());
    }

    // Method to find and display the words with minimum and maximum occurrences
    private static void findMinMaxRepeatedWords(Map<String, Integer> map) {
        int minCount = Integer.MAX_VALUE;
        int maxCount = Integer.MIN_VALUE;
        String minWord = "";
        String maxWord = "";

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            String word = entry.getKey();

            // Check for minimum occurrence
            if (count < minCount) {
                minCount = count;
                minWord = word;
            }

            // Check for maximum occurrence
            if (count > maxCount) {
                maxCount = count;
                maxWord = word;
            }
        }

        // Display words with minimum and maximum occurrences
        System.out.printf("%nWord with minimum occurrences: %s (count: %d)%n", minWord, minCount);
        System.out.printf("Word with maximum occurrences: %s (count: %d)%n", maxWord, maxCount);
    }
}
