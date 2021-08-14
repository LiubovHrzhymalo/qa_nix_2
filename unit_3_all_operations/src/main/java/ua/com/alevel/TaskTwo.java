package ua.com.alevel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskTwo {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please, enter the text");
        String a = scanner.nextLine();

            Map<Character, Integer> symbols = new HashMap<>();
            for (int i = 0; i < a.length(); i++) {
                if (Character.isLetter(a.charAt(i))) {

                    if (!symbols.containsKey(a.charAt(i))) {
                        symbols.put(a.charAt(i), 1);
                    } else {
                        int value = symbols.get(a.charAt(i));
                        symbols.put(a.charAt(i), value + 1);
                        symbols.put(a.charAt(i), symbols.get(a.charAt(i)) + 1);
                    }
                }
            }

            for (Map.Entry letters : symbols.entrySet()) {
                System.out.println(letters.getKey() + " - " + letters.getValue());


            }
        }
    }



