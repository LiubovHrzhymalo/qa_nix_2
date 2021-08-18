package ua.com.alevel;

public class StringRevers {
    private String dest;

    public String reverseOne(String a) {
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

    public String reverseThree(String text, String dest) {
        String reversedDest = reverseDest(dest);
        String result = text.replace(dest, reversedDest);
        System.out.println(result);
        return result;
    }

    public String reverseDest(String dest) {
        int stringLength = dest.length();
        String word = "";
        for (int i = 0; i < stringLength; i++) {
            word = dest.charAt(i) + word;
        }
        return word;
    }


}



