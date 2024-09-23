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
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,7,5,7,3,2,1};
        System.out.println(ValidMountainArray.validMountainArray(arr));
    }
}
