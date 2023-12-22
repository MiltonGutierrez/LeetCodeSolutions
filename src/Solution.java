import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to save my LeetCode solutions
 * @author Milton Andres Gutierrez Lopez
 */
public class Solution {
    //Problem : 2236. Root Equals Sum of Children
    public boolean checkTree(TreeNode root) {
        return (root.left.val + root.right.val) == root.val;
    }
    //Problem: 226. Invert Binary Tree
    public TreeNode invertTree(TreeNode root){
        if(root != null){
            invertRoots(root);
            return root;
        }
        else{
            return null;
        }
    }
    public void invertRoots(TreeNode root){
        if(root != null){
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = right;
            root.right = left;
            invertRoots(left);
            invertRoots(right);
        }
    }
    //1672. Richest Customer Wealth

    public int maximumWealth(int[][] accounts){
        if(accounts.length > 0){
            return maximumWealth(accounts, 0, 0);
        }
        else{
            return 0;
        }
    }
    
    /**
     * Sums all the values of of list of the matrix and returns the largest
     * @param accounts
     * @param cont
     * @param richest
     * @return
     */
    public int maximumWealth(int[][] accounts, int cont, int richest) {
        if(cont >= accounts.length){
            return richest;
        }  
        else{
            int possibleRichest = sumList(accounts[cont], 0, 0);
            if(possibleRichest > richest){
                richest = possibleRichest;
            }
            cont++;
            return maximumWealth(accounts, cont, richest);
        } 

    }
    /**
     * Sums the values of the list an returns the result
     * @param listToSum
     * @param cont
     * @param sumValue
     * @return
     */
    public int sumList(int[] listToSum, int cont, int sumValue){
        if(cont == listToSum.length){
            return sumValue;
        }
        else{
            sumValue += listToSum[cont];
            cont++;
            return sumList(listToSum, cont, sumValue);
        }
    }

    //412. Fizz Buzz
    public List<String> fizzBuzz(int n){
        ArrayList<String> fizzBuzzResult = new ArrayList<>();
        return fizzBuzz(fizzBuzzResult, n, 1);
            
    }

    public List<String> fizzBuzz(List<String> fizzBuzz, int n, int cont){
        if(cont == n + 1){
            return fizzBuzz;
        }
        else if(cont % 3 == 0 && cont % 5 == 0){
            fizzBuzz.add("FizzBuzz");
            cont++;
            return fizzBuzz(fizzBuzz, n, cont);
        }
        else if(cont % 3 == 0){
            fizzBuzz.add("Fizz");
            cont++;
            return fizzBuzz(fizzBuzz, n, cont);
        }
        else if(cont % 5 == 0){
            fizzBuzz.add("Buzz");
            cont++;
            return fizzBuzz(fizzBuzz, n, cont);
        }
        else{
            fizzBuzz.add(Integer.toString(cont));
            cont++;
            return fizzBuzz(fizzBuzz, n, cont);
        }
    }
    public static void main(String[] args){
        Solution s = new Solution();
        List<String> fizz = s.fizzBuzz(15);
        for(String i: fizz){
            System.out.println(i);
        }
    }
}