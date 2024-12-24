import java.util.Arrays;

public class HeightChecker {




    /*public static int heightChecker(int[] heights) {
        int unmatched = 0;
        int biggestNum = heights[unmatched];
        for(int i = 1; i < heights.length ; i ++){
            if(biggestNum < heights[i]) biggestNum = heights[i];

            if(heights[i] < heights[i-1] || heights[i] < biggestNum){
                unmatched++;
                System.out.println("index: " + i + " " + heights[i] + " < " + heights[i-1] + " index " + (i-1) );
            } 
        }
        if(biggestNum == heights[0] && unmatched > 0) unmatched++;
        return unmatched; // not working
    }*/

    public static int heightChecker(int[] heights) {
        int unmatched = 0;
        int[] expectedArray =heights.clone();
        Arrays.parallelSort(expectedArray);
        for(int i = 0; i < heights.length; i++){
            if(heights[i] != expectedArray[i]) unmatched++;
        }
        return unmatched;
    }

    public static void main(String[] args) {

        int[] heights = {1,2,3,4,5};
        System.out.println(HeightChecker.heightChecker(heights));
        
    }
    
}
