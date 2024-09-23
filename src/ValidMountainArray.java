public class ValidMountainArray {
    public static boolean validMountainArray(int[] arr){ //Ineficient solution
        int lastNumber = arr[0];
        int beak = -1;
        for(int i = 1; i < arr.length;i++){
            if(beak != -1){
                if(!(arr[i] < beak) || arr[i] > arr[i-1]){
                    return false;
                }
            }
            if(lastNumber < arr[i] && i + 1 < arr.length && arr[i] > arr[i+1]){ 
                if(beak == -1){
                    beak = arr[i];
                }
            }
            if(lastNumber > arr[i] && i + 1 < arr.length && arr[i] < arr[i+1]){ 
                return false;
            }

            if(i + 1 < arr.length && arr[i] == arr[i+1]){
                return false;
            }

        }
        if(beak == -1){
            return false;
        }
        return true;
    }
    
    public static boolean validMountainArray2(int[] arr){ //More efficient 
        if(arr == null || arr.length < 3) return false;
        if(arr.length > 2 && (arr[0] > arr[1] || arr[arr.length - 1] > arr[arr.length -2])) return false;
        int peak = arr[0];
        int i = 1;
        boolean foundPeak = false;
        while(i < arr.length){
            if(arr[i] == arr[i-1]){
                return false;
            }
            if(peak < arr[i]){
                peak = arr[i];
            }
            else{
                foundPeak = true;
            }
            if(foundPeak && arr[i] >= peak) return false;
            if(foundPeak && arr[i-1] < arr[i]) return false;
            i++;
        } 
        return true;
    }

    public static boolean validMountainArray3(int[] arr){ //Efficient Solution LeetCode submission (not mine)
        int arrLength = arr.length;
        if(arrLength < 3){
            return false;
        }
        
        int i = 0;

        while(i + 1 < arrLength && arr[i] < arr[i+1]){
            i++;
        }
        
        if(i == 0 || i == arrLength - 1){
            return false;
        }

        while(i + 1 < arrLength && arr[i] > arr[i+1]){
            i++;
        }
        
        if(i != arrLength){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,7,10,3,2,6,3,1};
        System.out.println(ValidMountainArray.validMountainArray3(arr));
    }
}
