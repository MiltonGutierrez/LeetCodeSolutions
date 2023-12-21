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
    public int maximumWealth(int[][] accounts, int cont, int richest) {
        if(cont >= accounts.length){
            return richest;
        }
        return 0;
    }

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

    public void main(String[] args){
        System.out.print(sumList(new int[]{1,1,1,1}, 0, 0));
    }
}