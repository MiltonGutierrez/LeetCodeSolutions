import java.util.Arrays;

public class ReplaceElements {
    public static int[] replaceElements(int[] arr) { //2ms solution made by me
        if(arr.length == 1) return new int[]{-1};
        int maxValue = arr[arr.length -1];
        int tempMax = -1;
        for(int i = arr.length - 2; i >= 0 ; i --){
            if(arr[i] > maxValue){
                tempMax = arr[i];
                arr[i] = maxValue;
                maxValue = tempMax;
            } 
            else{
                arr[i] = maxValue;
            }
        }
        arr[arr.length -1] = -1;
        return arr;
    }

    
    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        System.out.println(Arrays.toString(ReplaceElements.replaceElements(arr)));
    }
    
}
