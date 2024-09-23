public class CheckIfExist {

    /*i != j
    0 <= i, j < arr.length
    arr[i] == 2 * arr[j]*/

    public static boolean checkIfExist(int[] arr) {
        for(int i=0; i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[i]==arr[j]*2 && j!=i){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr = {10,2,5,3};
        System.out.println(checkIfExist(arr));
    }
}