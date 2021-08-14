package ua.com.alevel;

import java.util.Scanner;

public class StringRevers {

    public static String main(String[] args){
        Scanner text = new Scanner(System.in);

        System.out.print("Please, enter the text ");
        String a = text.nextLine();

        char[] array = a.toCharArray();
        String result = "";
        for (int i = array.length - 1; i >= 0; i--) {
            result = result + array[i];
        }
        return result;


    }
}



