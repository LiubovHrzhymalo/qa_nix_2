package ua.com.alevel.service;

import ua.com.alevel.model.ModelForFile;
import ua.com.alevel.model.TypeForFile;
import java.io.*;
import java.text.BreakIterator;
import java.util.*;
import java.util.stream.Collectors;
public class ServiceImpl implements ServiceForFile {

    public void create(ModelForFile modelForFile) {
        File file = null;
        switch (modelForFile.getFileType()) {
            case INPUT: {
                file = new File(modelForFile.getFileName() + ".txt");
            }
            break;
            case OUTPUT: {
                String inputContent = read(TypeForFile.INPUT.getFileName());
                String outputContent = getStatistic(inputContent);
                modelForFile.setFileContent(outputContent);
                file = new File( modelForFile.getFileName() + ".txt");
            }
            break;
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(modelForFile.getFileContent());
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    public void delete(String fileName) {
        if (!isExist(fileName)) {
            System.out.println(fileName + ".txt isn't found");
            System.out.println();
        } else {
            File file = new File(fileName + ".txt");
            file.delete();
            System.out.println(fileName + ".txt was deleted.");
            System.out.println();
        }
    }

    public String read(String fileName) {
        if (!isExist(fileName)) {
            System.out.println(fileName + ".isn't found");
        } else {
            File file = new File(fileName + ".txt");
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String fileContent;
                fileContent =  reader.lines().collect(Collectors.joining());
                reader.close();
                return fileContent;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private boolean isExist(String fileName) {
        File file = new File(fileName + ".txt");
        if(file.exists() && !file.isDirectory()) return true;

        return false;
    }

    private String getStatistic(String inputContent) {
        String strWithNoSpecSymbols = inputContent.trim().replaceAll("[^a-zA-Z]", " ");
        String[] words = strWithNoSpecSymbols.split("\\s+");

        String results = "Duplicates: " + getNumberOfDuplicates(words).toString() + "\n" +
                "Palindromes: " + getPalindromes(words).toString() + "\n" +
                "Number of Sentences: " + getSentencesNumber(inputContent);
        return results;
    }

    private Map<String, Integer> getNumberOfDuplicates(String[] words) {
        Map<String, Integer> wordMap = new HashMap<String, Integer>();

        HashSet<String> wordsSet = new HashSet<String>(Arrays.asList(words));

        for (String str : wordsSet) {
            str = str.toLowerCase();
            int wordCount = 0;
            for (int i = 0; i < words.length; i++) {
                if (str.equals(words[i].toLowerCase())) wordCount++;
            }
            wordMap.put(str, wordCount);
        }

        return wordMap.entrySet()
                .stream()
                .filter(map -> map.getValue().intValue() > 1)
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
    }

    private Map<String, Integer> getPalindromes(String[] words) {
        Map<String, Integer> wordMap = new HashMap<String, Integer>();

        for (String str : words) {
            str = str.toLowerCase();
            int wordCount = 0;
            for (int i = 0; i < words.length; i++) {
                if (str.equals(words[i].toLowerCase())) wordCount++;
            }
            if (isPalindrome(str)) {
                wordMap.put(str, wordCount);
            }
        }
        return wordMap;
    }

    private static boolean isPalindrome(String str) {
        if (str.length() == 1) {
            return false;
        } else if (str.length() == 2 || str.length() == 3) {
            return str.charAt(0) == str.charAt(str.length() - 1);
        } else if (str.length() % 2 == 0) {
            String str1 = str.substring(0, str.length() / 2);
            StringBuilder stringBuilder1 = new StringBuilder(str1);
            str1 = stringBuilder1.reverse().toString();
            String str2 = str.substring(str.length() / 2);
            return str1.equals(str2);
        } else if (str.length() % 2 == 1) {
            String str1 = str.substring(0, str.length() / 2);
            StringBuilder stringBuilder1 = new StringBuilder(str1);
            str1 = stringBuilder1.reverse().toString();
            String str2 = str.substring(str.length() / 2 + 1);
            return str1.equals(str2);
        }
        return false;
    }

    private int getSentencesNumber(String targetSentence) {

        Locale currentLocale = new Locale("en", "US");

        BreakIterator iterator
                = BreakIterator.getSentenceInstance(currentLocale);

        StringBuffer markers = new StringBuffer();

        markers.setLength(targetSentence.length() + 1);
        for (int k = 0; k < markers.length(); k++) {
            markers.setCharAt(k, ' ');
        }
        int count = 0;
        iterator.setText(targetSentence);
        int boundary = iterator.first();
        while (boundary != BreakIterator.DONE) {
            markers.setCharAt(boundary, '^');
            ++count;
            boundary = iterator.next();
        }

        return count - 1;
    }
}
