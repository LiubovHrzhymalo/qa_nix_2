package ua.com.alevel.util;
import java.util.*;

public  final class WriterText {
    public static Map<String, Integer> getWordsCount(String text) {
        List<String> words = getWords(text);
        Set<String> uniqueWords = new HashSet<>();
        uniqueWords.addAll(words);
        Map<String, Integer> wordsCount = new HashMap<>();
        for (String uw : uniqueWords) {
            int count = 0;
            for (String w : words) {
                if (uw.equals(w)) {
                    count++;
                }
            }
            wordsCount.put(uw, count);
        }
        Map<String, Integer> sortedByCount = new LinkedHashMap<>();

        wordsCount.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedByCount.put(x.getKey(), x.getValue()));
        return sortedByCount;
    }

    public static HashSet<String> getPalindrome(String text) {
        HashSet<String> palindromes = new HashSet<>();
        List<String> words = getWords(text);
        for (String w : words) {
            if (w.equals(new StringBuilder(w).reverse().toString())) {
                palindromes.add(w);
            }
        }
        return palindromes;
    }

    public static int getSentenceCount(String text) {
        List<String> sentences = Arrays.asList(text.split("[?!.]"));
        return sentences.size() - 1;
    }

    private static List<String> getWords(String text) {
        return Arrays.asList(text.toLowerCase()
                .replace("[.,:;!?]", "")
                .split(" "));
    }
}
