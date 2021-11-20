import java.util.*;

public class MyClass {

   public static void main(String[] args) {

       int[] numArray = {2, 1, 5, 7, 2, 0, 5};
       movingMedian(numArray);

       String[] stringsArray = {"baseball", "a,all,b,ball,bas,base,cat,code,d,e,quit,z"};
       wordSplit(stringsArray);

       int[] histArray = {2,1,5,6,2,3};
       System.out.println(findLargestArea(histArray, 1));

   }


    /**
     * Moving Median
     */
    public static double[] movingMedian(int[] numArray){

        double[] medianArray = new double[numArray.length];
        for (int i = 0; i < numArray.length; i++){

            int[] subArray = Arrays.copyOfRange(numArray, 0,   i+1);
            Arrays.sort(subArray);

            double median = 0;
            if (subArray.length % 2 == 0){
                //Even

                if (subArray.length == 0){
                    median = numArray[0];
                }else {
                    int index1 = subArray.length / 2;
                    int index2 = index1 - 1;

                    median = (double) ( subArray[index1] + subArray[index2] ) / 2;

                }


            }else {
                //Odd
                int index = subArray.length / 2;
                median = subArray[index];

            }

            medianArray[i] = median;

        }

        return medianArray;
    }

    /**
     * Word Split
     */
    public static String wordSplit(String[] stringsArray){

        if (stringsArray.length > 2){
            return "not possible.";
        }

        boolean isPresent = false;

        String arraysString1 = stringsArray[0];
        String[] arraysString2 = stringsArray[1].split(",");

        for (int i = 0; i < arraysString1.length(); i++){

            String string1 = arraysString1.substring(0, i + 1);
            String string2 = arraysString1.substring(i+1);

            if (Arrays.asList(arraysString2).contains(string1) && Arrays.asList(arraysString2).contains(string2)){
                isPresent = true;
                break;
            }

        }
        if (isPresent){
            return "Possible";
        }

        return "Not Possible";
    }

    /**
     *
     */
    public static int findLargestArea(int[] height, int width){

        int maxArea = 0;

        for (int i = 0; i < height.length; i++){

            if (i == 0){
                maxArea = height[0] * width;
            }
            for (int j = i; j >= 0; j--){

                int[] subArray = Arrays.copyOfRange(height, j,   i+1);
                int minHeightValue = Arrays.stream(subArray).summaryStatistics().getMin();
                int noBars = (i + 1) - j;
                int area = noBars * width * minHeightValue;

                if (area > maxArea)
                    maxArea = area;

            }
        }

        return maxArea;

    }

}



