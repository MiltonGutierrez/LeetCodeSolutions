
import java.lang.Math;
import java.util.Arrays;

public class ArraysCardTrack{
    public int findMaxConsecutiveOnes(int[] nums){
        int largetsConsecutive = 0;
        int possibleLargestConsecutive = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1) possibleLargestConsecutive++;
            else{
                if(possibleLargestConsecutive > largetsConsecutive){
                    largetsConsecutive = possibleLargestConsecutive;
                }
                possibleLargestConsecutive = 0;
    
            }
        }
        if(possibleLargestConsecutive > largetsConsecutive){
            largetsConsecutive = possibleLargestConsecutive;
        }
        return largetsConsecutive;   
    }
    /**
     * Returns the number of numbers in the array that have even number of digits (my idea)
     * @param nums
     * @return
     */
    public int findNumbers(int[] nums) {
        int evenNumbers = 0;
        for(Integer n: nums){
            if(n.toString().length() % 2 == 0){
                evenNumbers++;
            } 
        }
        return evenNumbers;
    }

    /*public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
 
        // Break the array in two halves
        int mid = array.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length - mid];
 
        System.arraycopy(array, 0, leftArray, 0, mid);
 
        if (array.length - mid >= 0){
            System.arraycopy(array, mid, rightArray, 0, array.length - mid);
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }
 
    private static void merge(int[] leftArray,
        int[] rightArray, int[] array) {
        int i = 0, j = 0, k = 0;
 
        // Effectively sorts left and right array
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }*/

    /**
     * Solution with better runtime (better logic)
     * @param nums
     * @return
     */
    public int findNumbers2(int[] nums){
        int evenNumbers = 0;
        for(int n: nums){
            if((int)(Math.log10(n) + 1) % 2 == 0){
                evenNumbers++;
            }
        }
        return evenNumbers;
    }
    /*public int[] sortedSquares(int[] nums){
        if(nums[0] >= 0){
            return sortedSquaresPositives(nums);
        }
        else if(nums[nums.length - 1] <= 0){
            return sortedSquaresNegatives(nums);
        }
        else{
            mergeSort(sortedSquaresPositives(nums));
            return nums;
        }
    }

    public int[] sortedSquaresPositives(int[] nums){
        for (int i = 0; i < nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }
        return nums;
    }   

    public int[] sortedSquaresNegatives(int nums[]){
        int limit = nums.length - 1;
        for (int i = limit; i > limit / 2; i--){
            int baseNumber = nums[i] * nums[i];
            int numberToChange = nums[limit - i ] * nums[limit - i];
            nums[i] = numberToChange;
            nums[limit - i] = baseNumber;
        }
        if(nums.length % 2 != 0){
            int index = (nums.length - 1) / 2;
            nums[index] = nums[index] * nums[index];
        }
        return nums;
    }*/
    /*  Less eficient but simplier
    public int[] sortedSquares(int[] nums){
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;        
    }*/
    
    //Faster solution (not mine) I adjusted it to make it more readable for me
    public int[] sortedSquares(int[] nums) {
        int[] output = new int[nums.length];
        int p1 = 0, p2 = nums.length - 1;
        for (int i = output.length - 1; i >= 0; i--) {
            if(Math.abs(nums[p1]) > Math.abs(nums[p2])){
                System.out.println("nums[p1] > nums[p2]");
                System.out.println("Index loop " + i);
                System.out.println("numeros p1: " + nums[p1]);
                System.out.println("Index p1 " + p1);
                System.out.println("Index p1++" + (p1+1));
                output[i] = nums[p1] * nums[p1];
                p1++;
                System.out.println("Output[i]: " + output[i]);
                System.out.println();
            }
            else{
                System.out.println("nums[p1] < nums[p2]");
                System.out.println("Index loop " + i);
                System.out.println("Index p2 " + p2);
                System.out.println("Index p2--" + (p2-1));
                System.out.println("numeros p2: " + nums[p2]);
                output[i] = nums[p2] * nums[p2];
                p2--;
                System.out.println("Output[i]: " + output[i]);
                System.out.println();
            }
        }

        return output;
    }
    //First Solution 
    public void duplicateZeros(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                moveToTheRigth(arr, i);
                i++;
            }
        }
    }

    public void moveToTheRigth(int[] arr, int startIndex){
        for(int i = arr.length - 1; i > startIndex; i--){
            arr[i] = arr[i - 1];
        }
    }

    public void duplicateZeros1(int[] arr) {
        int n = arr.length;

        int[] temp = arr.clone();//for copy arr

        int ind = 0;

        for(int i=0; ind<n; i++){
            arr[ind++] = temp[i];
            if(temp[i] == 0 && ind != n)arr[ind++] = 0;
        }
    }
    //My solution based on the mergeSort algoritm, and duplicate zeros.

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temporal = new int[m];
        System.arraycopy(nums1, 0, temporal, 0, m);
        int i = 0, j = 0, k = 0; // i para el arreglo copia, k para el arrego nums2, k para el arreglo nums1
        while(i < m && j < n && k < m + n){
            if(temporal[i] < nums2[j]){
                nums1[k++] = temporal[i++];
            }
            else{
                nums1[k++] = nums2[j++];
            }
        }
        if(j < n){
            while(k < m + n){
                nums1[k++] = nums2[j++];
            }
        }
        else if (i < m){
            while(k < m + n){
                nums1[k++] = temporal[i++];
            }
        }

    }
    /**
     * Withouth comments
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int nonValElements = 0;
        int i = 0, j = nums.length -1;
        while (i < nums.length -1 && j >= 0){
            if(j == i){
                break;
            }
            if(nums[i] == val || nums[j] == val){
                if(nums[i] == val){
                    int valueToChange = nums[j];
                    nums[j] = nums[i];
                    nums[i] = valueToChange;
                    nonValElements++;
                    j--;
                    if( j < 0){
                        break;
                    }
                }
                if(nums[j] == val){
                    nonValElements++;
                    j--;
                    if( j < 0){
                        break;
                    }
                }
            }
            else{
                i++;
            }
        }
        if(nums.length == 1 && nums[0] == val){
            nums[0] = 0;
            return 0;
        }
        else if(nums.length % 2 != 0  && nums[0] == val){
            nonValElements++;
        }
        return nums.length -nonValElements;
    }
    public static void main(String[] args) {
        ArraysCardTrack a = new ArraysCardTrack();
        int[] nums1 = {3,3,3,3,3};
        int ele = a.removeElement(nums1, 3);
        for (int n: nums1){
            System.out.println(n);
        }
        System.out.println();
        System.out.println(ele);
    }

}