package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class task1 {

    public static void main(String[] args) {

        String str = "sdfa3214adsf41agsd";
        int sizeOfStr = str.length();
        int sum = 0;
        int tempNum = 0;
        for (int i = 0; i < sizeOfStr; ++i) {
            if (Character.isDigit(str.charAt(i))) {
                tempNum = (10 * tempNum) + Character.getNumericValue(str.charAt(i));
            } else {
                sum += tempNum;
                tempNum = 0;
            }
        }
        sum += tempNum;
        System.out.println(sum);
        sum += tempNum;
        System.out.println(sum);
        sum += tempNum;
        System.out.println(sum);
    }
}