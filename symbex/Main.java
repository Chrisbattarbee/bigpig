import java.util.*;

public class Main {

    // DONE
    private static String shiftingLetters(String s, int[] shifts) {
        int len = shifts.length;

        for (int i = len - 2; i >= 0; i--) {
            shifts[i] += shifts[i + 1] % 26;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ((chars[i] - 'a' + shifts[i]) % 26 + 'a');
        }
        return new String(chars);
    }

    public static String toString(int s) {
        if(s == 3) {
            return "3";
        }
        if(s == 4) {
            return "4";
        }
        if(s == 9) {
            return "9";
        }
        if(s == 121) {
            return "121";
        }
        return Integer.toString(s);
    }

    public static void main(String[] args) {
        //System.out.println("Result is " + shiftingLetters(inputString, input));
        System.out.println(toString(3));
    }
}
