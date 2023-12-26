
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

    public static void main(String[] args) {
        ArraysCardTrack a = new ArraysCardTrack();
        int[] sorted = a.sortedSquares(new int[]{-10,-5,-1,0,1,5,10});
        for (int n: sorted){
            System.out.println(n);
        }
        System.out.println();
    }

}