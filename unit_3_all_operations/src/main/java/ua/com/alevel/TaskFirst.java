package ua.com.alevel;
import java.util.Scanner;

public class TaskFirst {
    public void run() {
            Scanner text = new Scanner(System.in);
            System.out.print("Please, enter the text ");
            String a = text.next();

            int sum = 0;
            for (int i = 0; i < a.length(); i++) {
                if (Character.isDigit(a.charAt(i))) {
                    sum = sum + Integer.parseInt(a.charAt(i) + "");
                }
            }
            System.out.println("Sum of numbers: " + sum);
        }
}





