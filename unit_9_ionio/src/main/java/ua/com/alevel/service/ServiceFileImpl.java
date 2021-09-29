package ua.com.alevel.service;

import ua.com.alevel.model.FileModel;
import ua.com.alevel.model.TypeFile;
import java.io.*;
import java.text.BreakIterator;
import java.util.*;
import java.util.stream.Collectors;

public class ServiceFileImpl implements ServiceFile{
    @Override
    public void create(FileModel fileModel) {
        File file = new File(fileModel.getNameFile() );
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(fileModel.getContentFile());
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public String read(String fileName) {
        String contentFile = "";
        File file = new File(fileName);
        try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file))) {
            String line = lineNumberReader.readLine();
            while (line != null) {
                contentFile = contentFile.concat(line).concat(" ");
                line = lineNumberReader.readLine();
            }
            return contentFile;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getOutput(String input) {
        return null;
    }

//    @Override
//    public String getOutput(String input) {
//        String output = "\nThe text includes:\n";
//        Map<String, Integer> wordsCount = Text.getWordsCount(input);
//        for (String key : wordsCount.keySet()) {
//            output = output.concat(key + " - " + wordsCount.get(key) + "\n");
//        }
//        output = output.concat("\nPalindromes:\n");
//        HashSet<String> palindromes = Text.getPalindrome(input);
//        for (String palindrome : palindromes) {
//            output = output.concat(palindrome + " - " + wordsCount.get(palindrome) + "\n");
//        }
//        output = output.concat("\nTotal number of  sentences: " + Text.getSentenceCount(input));
//        return output;
//    }
}
