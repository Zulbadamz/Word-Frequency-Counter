import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> wordCount = new HashMap<>();

        System.out.println("Enter text (type 'exit' on a new line to finish):");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("exit")) break;

            // Normalize and remove punctuation
            line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
            String[] words = line.split("\\s+");

            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }

        scanner.close();

        // Sort words alphabetically using TreeMap
        Map<String, Integer> sortedMap = new TreeMap<>(wordCount);

        // Display results
        System.out.println("\nWord Frequency Count:");
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

