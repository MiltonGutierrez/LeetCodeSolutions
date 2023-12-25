
import java.lang.Math;

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
    
    public static void main(String[] args) {
        ArraysCardTrack a = new ArraysCardTrack();
        System.out.println(a.findNumbers2(new int[] {1,22,4352,12}));
    }

}