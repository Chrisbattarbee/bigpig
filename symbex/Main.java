import java.util.*;

public class Main {

    // DONE
    public static String shiftingLetters(String s, int[] shifts) {
        int len = shifts.length;

        if (len < 10) {
          System.out.println("Ord of _ is " + (int)'_');
        }

        for (int i = len - 2; i >= 0; i--) {
            shifts[i] += shifts[i + 1] % 26;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ((chars[i] - 'a' + shifts[i]) % 26 + 'a');
        }
        if (chars[0] == 'a') {
          System.out.println("First letter is a!");
        }
        return new String(chars);
    }


    public static void main(String[] args) {
        int[] input = new int[]{10, 20, 30};
        String inputString  = "bad";
        System.out.println("Ord of _ is " + (int)'_');
        System.out.println("Input array is " + Arrays.toString(input));
        System.out.println("Input string is " + inputString);

        System.out.println("Result is " + shiftingLetters(inputString, input));
    }
}
