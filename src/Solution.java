import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.lang.model.util.ElementScanner14;

/**
 * Class to save my LeetCode solutions
 * 
 * @author Milton Andres Gutierrez Lopez
 */
public class Solution {
    // Problem : 2236. Root Equals Sum of Children
    public boolean checkTree(TreeNode root) {
        return (root.left.val + root.right.val) == root.val;
    }

    // Problem: 226. Invert Binary Tree
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            invertRoots(root);
            return root;
        } else {
            return null;
        }
    }

    public void invertRoots(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = right;
            root.right = left;
            invertRoots(left);
            invertRoots(right);
        }
    }
    // 1672. Richest Customer Wealth

    public int maximumWealth(int[][] accounts) {
        if (accounts.length > 0) {
            return maximumWealth(accounts, 0, 0);
        } else {
            return 0;
        }
    }

    /**
     * Sums all the values of of list of the matrix and returns the largest
     * 
     * @param accounts
     * @param cont
     * @param richest
     * @return
     */
    public int maximumWealth(int[][] accounts, int cont, int richest) {
        if (cont >= accounts.length) {
            return richest;
        } else {
            int possibleRichest = sumList(accounts[cont], 0, 0);
            if (possibleRichest > richest) {
                richest = possibleRichest;
            }
            cont++;
            return maximumWealth(accounts, cont, richest);
        }

    }

    /**
     * Sums the values of the list an returns the result
     * 
     * @param listToSum
     * @param cont
     * @param sumValue
     * @return
     */
    public int sumList(int[] listToSum, int cont, int sumValue) {
        if (cont == listToSum.length) {
            return sumValue;
        } else {
            sumValue += listToSum[cont];
            cont++;
            return sumList(listToSum, cont, sumValue);
        }
    }

    // 412. Fizz Buzz
    public List<String> fizzBuzz(int n) {
        ArrayList<String> fizzBuzzResult = new ArrayList<>();
        return fizzBuzz(fizzBuzzResult, n, 1);

    }

    public List<String> fizzBuzz(List<String> fizzBuzz, int n, int cont) {
        if (cont == n + 1) {
            return fizzBuzz;
        } else if (cont % 3 == 0 && cont % 5 == 0) {
            fizzBuzz.add("FizzBuzz");
            cont++;
            return fizzBuzz(fizzBuzz, n, cont);
        } else if (cont % 3 == 0) {
            fizzBuzz.add("Fizz");
            cont++;
            return fizzBuzz(fizzBuzz, n, cont);
        } else if (cont % 5 == 0) {
            fizzBuzz.add("Buzz");
            cont++;
            return fizzBuzz(fizzBuzz, n, cont);
        } else {
            fizzBuzz.add(Integer.toString(cont));
            cont++;
            return fizzBuzz(fizzBuzz, n, cont);
        }
    }

    // Ternary Solution (Not mine) link:
    // https://leetcode.com/problems/fizz-buzz/solutions/2628136/java-3-approaches-easy
    public List fizzBuzz2(int n) {
        List ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ans.add(
                    i % 15 == 0 ? "FizzBuzz" : i % 5 == 0 ? "Buzz" : i % 3 == 0 ? "Fizz" : String.valueOf(i));
        }

        return ans;
    }

    // Problem 1342. Number of steps to Reduce a Number to Zero
    public int numberOfSteps(int n) {
        return numberOfSteps(n, 0);

    }

    public int numberOfSteps(int n, int cont) {
        if (n == 0) {
            return cont;
        } else if (n % 2 == 0) {
            return numberOfSteps(n / 2, cont + 1);
        } else {
            return numberOfSteps(n - 1, cont + 1);
        }
    }

    // Problem 876 Middle of the linked list
    public ListNode middleNode(ListNode head) {
        int length = (listNodeLength(head) / 2) + 1;
        ListNode middNode = head;
        for (int i = 0; i < length; i++) {
            middNode = middNode.next;
        }
        return middNode;
    }

    public int listNodeLength(ListNode head) {
        int length = 1;
        if (head.next != null) {
            ListNode next = head.next;
            while (next != null) {
                next = next.next;
                length++;
            }
        }
        return length;

    }

    // Problem 383. RansomNote (not efficient) first solution
    public boolean canConstruct1(String ransomNote, String magazine) {
        boolean result = true;
        HashMap<Character, Integer> magazinHashMap = getHashMap1(magazine);
        HashMap<Character, Integer> ramsonNoteHashMap = getHashMap1(ransomNote);
        char[] charsToCompare = ransomNote.toCharArray();
        for (char c : charsToCompare) {
            if (magazinHashMap.containsKey(c) && result) {
                result = ramsonNoteHashMap.get(c) <= magazinHashMap.get(c);
            } else {
                return false;
            }
        }
        return result;
    }

    public HashMap<Character, Integer> getHashMap1(String toConstruct) {
        HashMap<Character, Integer> result = new HashMap<>();
        char[] chars = toConstruct.toCharArray();
        for (char c : chars) {
            if (!result.containsKey(c)) {
                result.put(c, 1);
            } else {
                Integer i = result.get(c) + 1;
                result.remove(c);
                result.put(c, i);
            }
        }
        return result;
    }

    // Problem 383. RansomNote (not efficient) (Video solution )
    public boolean canConstruct2(String ransomNote, String magazine) {
        HashMap<Character, Integer> magazinHashMap = getHashMap2(magazine);
        for (char c : ransomNote.toCharArray()) {
            int currentCount = magazinHashMap.getOrDefault(c, 0);
            if (currentCount == 0) {
                return false;
            }

            magazinHashMap.put(c, currentCount - 1);
        }
        return true;
    }

    public HashMap<Character, Integer> getHashMap2(String toConstruct) {
        HashMap<Character, Integer> result = new HashMap<>();
        for (char c : toConstruct.toCharArray()) {
            int currentCount = result.getOrDefault(c, 0);
            result.put(c, currentCount + 1);
        }
        return result;
    }

    // RansomeNote solution 3 (not my idea) link:
    // https://leetcode.com/problems/ransom-note/solutions/1671552/1ms-100-easy-explanation-java-solution/

    public boolean canConstruct3(String ransomeNote, String magazine) {
        int[] counter = new int[26];
        for (char c : magazine.toCharArray()) {
            counter[c - 'a']++;
        }
        for (char c : ransomeNote.toCharArray()) {
            if (counter[c - 'a'] == 0)
                return false;
            counter[c - 'a']--;
        }
        return true;
    }

    // Exercises from Card Track arrays
    public int findMaxConsecutiveOnes(int[] nums) {
        int largetsConsecutive = 0;
        int possibleLargestConsecutive = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                possibleLargestConsecutive++;
            else {
                if (possibleLargestConsecutive > largetsConsecutive) {
                    largetsConsecutive = possibleLargestConsecutive;
                }
                possibleLargestConsecutive = 0;

            }

        }
        if (possibleLargestConsecutive > largetsConsecutive) {
            largetsConsecutive = possibleLargestConsecutive;
        }
        return largetsConsecutive;
    }//

    public static int thirdMax(int[] nums) {
        Integer firstMax = nums[0];
        Integer secondMax = null;
        Integer thirdMax = null;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > firstMax) {
                if (secondMax != null || !firstMax.equals(secondMax)) {
                    thirdMax = secondMax;
                    secondMax = firstMax;
                }
                firstMax = nums[i];
                System.out.println("INDEX: " + i + " NUM " + nums[i] + " FIRST");
                System.out.println("FIRST " + firstMax + " SECOND " + secondMax + " THIRD " + thirdMax);
            } else {
                if (secondMax != null && nums[i] > secondMax && nums[i] != firstMax) {
                    thirdMax = secondMax;
                    secondMax = nums[i];
                    System.out.println("INDEX: " + i + " NUM " + nums[i] + " SECOND ");
                    System.out.println("FIRST " + firstMax + " SECOND " + secondMax + " THIRD " + thirdMax);
                } else if (secondMax != null && nums[i] < secondMax) {
                    if (thirdMax == null)
                        thirdMax = nums[i];
                    if (nums[i] > thirdMax)
                        thirdMax = nums[i];
                    System.out.println("INDEX: " + i + " NUM " + nums[i] + " SECOND ");
                    System.out.println("FIRST " + firstMax + " SECOND " + secondMax + " THIRD " + thirdMax);
                } else if (secondMax == null && nums[i] != firstMax) {
                    secondMax = nums[i];
                }
            }
        }
        System.out.println("FINAL: FIRST " + firstMax + " SECOND " + secondMax + " THIRD " + thirdMax);
        return (thirdMax != null) ? thirdMax : firstMax; 
    }

    public static int thirdMax2(int[] nums) {
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
                System.out.println("NUM " + num + " FIRST");
                System.out.println("FIRST " + firstMax + " SECOND " + secondMax + " THIRD " + thirdMax);
            } else if (firstMax > num && secondMax < num) {
                thirdMax = secondMax;
                secondMax = num;
                System.out.println("NUM " + num + " SECOND");
                System.out.println("FIRST " + firstMax + " SECOND " + secondMax + " THIRD " + thirdMax);
            } else if (num > thirdMax && num < secondMax) {
                thirdMax = num;
                System.out.println("NUM " + num + " THIRD");
                System.out.println("FIRST " + firstMax + " SECOND " + secondMax + " THIRD " + thirdMax);
            }
        }
        System.out.println("FINAL: FIRST "+firstMax+" SECOND "+secondMax+" THIRD "+thirdMax);
        return(thirdMax==Long.MIN_VALUE)?(int)firstMax:(int)thirdMax;
    }

    public static  List<Integer> findDisappearedNumbers(int[] nums) {
        int[] nums2 = new int[nums.length+1];
        for(int num: nums){
            nums2[num] = num;
        }  
        ArrayList<Integer> missingIntegers = new ArrayList<>(); 
        for(int i=1; i<nums2.length; i++){
            if(nums2[i] == 0){
                missingIntegers.add(i);
            }
        }
        return missingIntegers;
    }

    public static void squareAnArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i] * arr[i];
        }
    }

    public static int[] sortedSquares(int[] nums) {
        if(nums[0] >= 0){
            squareAnArray(nums);
            return nums;
        }
        squareAnArray(nums);
        Arrays.sort(nums);
        return nums;   
    }

    public static void lookForGreaterNumber(int[] nums, int left){
        int right = left + 1;
        int leftNum = Math.abs(nums[left]);
        int rightNum = Math.abs(nums[right]);
        
        while (leftNum < rightNum && nums[right] < 0){
            System.out.println("LEFT: "+leftNum+" RIGHT: "+rightNum);

            nums[right] = -leftNum;
            nums[left] = -rightNum;
            right++;
            left++;
            leftNum = Math.abs(nums[left]);
            rightNum = Math.abs(nums[right]);
            System.out.println(Arrays.toString(nums));
        }
        System.out.println("FINAL " + Arrays.toString(nums));
        
    }

    public static int[] sortedSquares2(int[] nums) {
        if(nums[0] >= 0){
            for(int i = 0; i < nums.length; i++){
                nums[i] = nums[i] * nums[i];
            }
            return nums;
        }
        int left = 0;
        int right = nums.length -1;

        while (left <= right){
            int leftNum = Math.abs(nums[left]);
            int rightNum = Math.abs(nums[right]);
            System.out.println("LEFT: "+leftNum+" RIGHT: "+rightNum);
            System.out.println();
            if(leftNum > rightNum){
                System.out.println("LEFT > RIGHT");
                nums[right] = leftNum * leftNum;
                nums[left] = -rightNum;
                System.out.println("nums[right] "+nums[right]+" nums[left] "+nums[left]);
                right--;
                
                System.out.println("LEFT: "+left+" RIGHT: "+right);
                System.out.println(Arrays.toString(nums));
                System.out.println();
                lookForGreaterNumber(nums, left);
            }
            else if(rightNum > leftNum){
                System.out.println("RIGHT > LEFT");
                nums[right] = rightNum * rightNum;
               System.out.println("nums[right] "+nums[right]+" nums[left] "+nums[left]);
                right--;
                System.out.println("LEFT: "+left+" RIGHT: "+right);
                System.out.println(Arrays.toString(nums));
                System.out.println();
            }
            else if (rightNum == leftNum){
                nums[right] = rightNum * rightNum;
                right--;
            }
            else{
                left++;
            }

            
        }
        return nums;
    }


    public static int[] sortedSquares3(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length -1;
        int index = nums.length -1;
        while(left <= right){
            int leftNum = nums[left] * nums[left];
            int rightNum = nums[right] * nums[right];
            if(leftNum > rightNum){
                result[index] = leftNum;
                left++;
            }
            else if(leftNum < rightNum){
                result[index] = rightNum;
                right--;
            }
            else if(leftNum == rightNum){
                result[index--] = rightNum;
                if(index >= 0 ){
                    result[index] = leftNum;
                }
                left++;
                right--;
            }
            index--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,1};
        System.out.println(Arrays.toString(Solution.sortedSquares3(nums)));
    }
}