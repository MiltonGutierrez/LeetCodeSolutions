import java.util.Arrays;

public class RemoveDuplicates{
    
    public static int removeDuplicates(int[] nums) {
        int revomedDuplicates = 0;
        int repeatedNumber = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(repeatedNumber == nums[i] ){ //Finds the duplicates converting them into 101
                nums[i] = 101;
                revomedDuplicates++;
            }
            else{
                repeatedNumber = nums[i];
            }
        }
        int indexToMoveTo = -1;
        int indexToMoveFrom = 0;
        boolean foundIndexToMoveTo = false;

        while(indexToMoveTo < nums.length && indexToMoveFrom < nums.length){
            if(nums[indexToMoveFrom] == 101 && foundIndexToMoveTo == false){ // Finding the first indexToMoveTo
                indexToMoveTo = indexToMoveFrom;
                foundIndexToMoveTo = true;
            }
            if(nums[indexToMoveFrom] != 101 && foundIndexToMoveTo){ //If there's a first index to move to and there's no more duplicates
                nums[indexToMoveTo] = nums[indexToMoveFrom]; //Move the different number to the indexToMoveTo
                nums[indexToMoveFrom] = 101;
                if(nums[indexToMoveTo+1] == 101){//If in the next index from indexToMoveTo there's a duplicate, select it ass the indexToMoveTo
                    indexToMoveTo++;
                }
            }
            indexToMoveFrom++; 

        }
        int newLength = nums.length - revomedDuplicates;
        return newLength;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1};
        System.out.println(RemoveDuplicates.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
        
    }
    
}