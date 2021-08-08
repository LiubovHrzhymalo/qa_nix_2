


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args) {


            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter string for counting letters in it:");

            String newString = myObj.nextLine();
            Map<Character, Integer> result = new HashMap<>();

            for (int i = 0; i < newString.length(); i++) {

                if (Character.isLetter(newString.charAt(i))) {
                    if (!result.containsKey(newString.charAt(i))) {
                        result.put(newString.charAt(i), 1);
                    } else {
                        int value = result.get(newString.charAt(i));
                        result.put(newString.charAt(i), value + 1);
                    }
                }
            }

            for (Map.Entry letters : result.entrySet()) {
                System.out.println(letters.getKey() + " - " + letters.getValue());

        }
    }
}