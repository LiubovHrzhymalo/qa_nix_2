package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskFirst {
    public static void main(String[] args) {
        System.out.println("Please, enter text");
    }

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String text = "";

        try {
            text = bufferedReader.readLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

//        String newString = text.nextLine();

    int result = 0;

        for(
    int i = 0; i<text.length();i++)

    {

        if (Character.isDigit(text.charAt(i))) {
            result += Character.digit(text.charAt(i), 10);
        }


        System.out.println("Result = " + result);

    }
}



