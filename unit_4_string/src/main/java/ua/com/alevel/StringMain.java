package ua.com.alevel;

import java.util.Scanner;

public class StringMain {

    public static void main(String[] args) {
        StringRevers stringReverse = new StringRevers();
        Scanner text = new Scanner(System.in);
        System.out.print("Please, enter the text ");
        String a = text.nextLine();
        System.out.println(stringReverse.reverseOne(a));
        System.out.println();
        System.out.print("Please, enter the text ");
        String b = text.nextLine();
        System.out.println(stringReverse.reverseTwo(b, true));
        System.out.println();
    }
}
