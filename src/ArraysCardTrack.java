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
}