import java.util.Arrays;
 
 
 
public class SortOddEven{
    public static int[] sortArrayByParity(int[] nums) { // 1ms solution done by myself
       
        int[] copyNums= new int[nums.length];
        int oddIndex = nums.length -1;
        int evenIndex = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] % 2 == 0){
                copyNums[evenIndex] = nums[i];
                evenIndex++;
 
            }
            else{
                copyNums[oddIndex] = nums[i];
                oddIndex--;
               
            }
        }
 
       
        return copyNums;
    }
    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
 
        System.out.println(Arrays.toString(SortOddEven.sortArrayByParity(nums)));
       
    } 
}
