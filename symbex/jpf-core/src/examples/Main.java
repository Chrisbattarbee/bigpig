import java.util.*;

public class Main {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static String serialiseTree(TreeNode root) {
        if (root == null) return Collections.singletonList(null).toString();

        List<Integer> serialised = new ArrayList<>();
        serialised.add(0, root.val);
        serialiseTreeIndexed(root.left, 1, serialised);
        serialiseTreeIndexed(root.right, 2, serialised);

        return serialised.toString();
    }

    private static void serialiseTreeIndexed(TreeNode root, int index, List<Integer> serialised) {
        if (root == null) return;
        serialised.add(index, root.val);
        serialiseTreeIndexed(root.left, index * 2, serialised);
        serialiseTreeIndexed(root.right, index * 2 + 1, serialised);
    }

    private static TreeNode deserialiseTree(String tree) {
        return null;
    }

    private static int[] setMismatch(int[] nums) {
        Arrays.sort(nums);

        int missing = 0;
        int duplicate = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) missing = i;

            if (nums[i] >= nums[i+1]) duplicate = nums[i];

            if (missing != 0 & duplicate != 0) return new int[]{duplicate, missing};
        }

        return null;
    }

    // DONE
    private static List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length;

        int[] dividers = new int[n];
        int[] prev = new int[n];

        Arrays.sort(nums);

        int max = 1, index = 0;

        for (int i = 0; i < n; i++) {
            dividers[i] = 1;
            prev[i] = -1;

            for (int j = i - 1; j >= 0; j--) {

                if (nums[i] % nums[j] == 0) {
                    if (dividers[i] < dividers[j] + 1) {
                        dividers[i] = dividers[j] + 1;
                        prev[i] = j;
                    }
                }

                if (dividers[i] > max) {
                    max = dividers[i];
                    index = i;
                }

            }


        }

        // Now we have the index of the "most divisible" element
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            result.add(nums[index]);
            index = prev[index];
        }

        return result;

    }

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

    private int compareVersion(String version1, String version2) {
        String[] v1 = version1.split(".");
        String[] v2 = version2.split(".");
        boolean biggerLength = v1.length >= v2.length;
        int len  = biggerLength ? v1.length : v2.length;
        int diff = 0;
        for (int i = 0; i < len; i++) {
            diff = Integer.parseInt(v1[i]) - Integer.parseInt(v2[i]);
            if (diff > 0) return 1;
            if (diff < 0) return -1;
        }

        return 0;

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
