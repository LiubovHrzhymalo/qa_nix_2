package ua.com.alevel;

public class StringRevers {

    private String dest;

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

    public  String reverseThree(String c, String a) {
       String reversedDest = reverseDest(dest);
        String result = a.replace(dest, reversedDest);
        return result;
}
    String reverseDest(String dest) {
        int stringLength = dest.length();
        String result = "";
        for (int i = 0; i < stringLength; i++) {
            result = dest.charAt(i) + result;
        }
        return result;
    }





}



