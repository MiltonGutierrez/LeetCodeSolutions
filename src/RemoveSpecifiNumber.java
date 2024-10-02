
import java.util.Arrays;
public class RemoveSpecifiNumber {
    public static int removeElement(int[] nums, int val) {
        int nonValElements = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[nonValElements] = nums[i];
                nonValElements++;
            }
        }
        return nonValElements;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,2,5,8,10,14,0,0,0,0,16,18};
        System.out.println(RemoveSpecifiNumber.removeElement(nums, 0));
        System.out.println(Arrays.toString(nums));

    }
    
}
