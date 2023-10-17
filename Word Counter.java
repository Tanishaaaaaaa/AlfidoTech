import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the text for word counting:");
        String inputText = scanner.nextLine();

        int totalWordCount = 0;
        int totalWordLength = 0;
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        String[] words = inputText.split("\\s+"); // Split by whitespace
        for (String word : words) {
            // Remove punctuation and non-alphabetical characters
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!word.isEmpty()) {
                totalWordCount++;
                totalWordLength += word.length();

                // Update word frequency
                wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
            }
        }

        double averageWordLength = (double) totalWordLength / totalWordCount;

        System.out.println("Word count: " + totalWordCount);
        System.out.println("Average word length: " + averageWordLength);
        System.out.println("Word frequencies:");

        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}
