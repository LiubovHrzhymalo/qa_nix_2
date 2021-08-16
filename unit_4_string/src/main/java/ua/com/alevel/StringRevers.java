package ua.com.alevel;

import java.util.Scanner;

public class StringRevers {

    public  String reverseOne(String a) {
        char[] array = a.toCharArray();
        String result = "";
        for (int i = array.length - 1; i >= 0; i--) {
            result = result + array[i];
        }
        return result;
    }

    public String reverseTwo(String a, boolean reverseTwo) {
        String[] array = a.split(" ");
       String result = "";
        for (int i = 0; i < array.length; i++) {
           result = result + reverseOne(array[i]) + " ";
        }
        return result;
   }
}
