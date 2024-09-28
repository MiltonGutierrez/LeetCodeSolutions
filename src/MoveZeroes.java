import java.util.Arrays;
public class MoveZeroes {
    public static int[] moveZeroes(int[] nums) {
        int nonZeroNumbers = -1;
        int zeroes = 0;
        for(int i = 0; i<nums.length; i++){ 
            if(nums[i] != 0){
                nonZeroNumbers++;
                if(zeroes > 0){
                    nums[nonZeroNumbers] = nums[i];
                    nums[i] = 0;   
                }                
                     
            }
            else{
                zeroes++;
            }
    
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] zeroes = {0,1,0,3,12,16};
        System.out.println((Arrays.toString(MoveZeroes.moveZeroes((zeroes)))));
    }
    
}
