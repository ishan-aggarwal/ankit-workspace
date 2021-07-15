package project4;

import java.util.*;

public class WayFinder {

    public static void main(String[] args) {

        if (!commandLineArgValidation(args)) return;


        //Create a integer array from the command line arguments
        int arr[] = new int[args.length];
        int i=0;
        for (String s: args){
            if(s!=null || !s.isEmpty())
            arr[i++] = Integer.valueOf(s);
        }

        if (!validateInput(arr)) return;

        Set<Integer> indices = new LinkedHashSet<>();
        String str ="";
        List<String> finalList = new LinkedList<>();
        calcWaysThruPuzzle(arr, 0, indices, str, finalList);

        if(finalList.size() == 0){
            System.out.println("No way through this puzzle.");
        }
        else {
            for(String st : finalList){
                System.out.println(st);
            }
            System.out.println("There are "+ finalList.size()+ " ways through the puzzle");
        }
    }

    private static boolean validateInput(int[] arr) {
        int i;
        if(arr[arr.length-1] !=0) {
            System.out.println("ERROR: the last value in the puzzle has to be zero.");
            return false;
        }

        for( i=0; i< arr.length; i++){

            if(arr[i] < 0){
                System.out.println("ERROR: the puzzle values have to be positive integers.");
                return false;
            }

            if(arr[i] > 99){
                System.out.println("ERROR: Values out of range.");
                return false;
            }
        }
        return true;
    }

    private static boolean commandLineArgValidation(String[] args) {
        if(args.length<2){
            System.out.println("ERROR: the arguments passed are not valid");
            return false;

        }
        return true;
    }

    private static void calcWaysThruPuzzle(int[] arr, int index, Set<Integer> indices, String str, List<String> finalList) {

        if(index <0 || index > arr.length-1) return;

        if(arr[index] == 0 && index == arr.length-1){
            StringBuilder sb = new StringBuilder();
            Object[] idxArr = indices.toArray();
            String[] newStr = str.trim().split(" ");
            for(int i=0 ;i <idxArr.length;i++){
                String val =newStr[i];
                int idx = (int) idxArr[i];
                sb.append("[");
                for(int j=0; j< arr.length; j++){

                    if(j ==idx ){
                        if(val.length() <2 && j!=0) sb.append(" ");
                        if(j!=0) sb.append(" ");
                        sb.append(" "+val);
                    }else {
                        if(j !=0) sb.append(" ");
                        if(arr[j] <10) sb.append(" ");
                                sb.append(arr[j]+" ");
                    }
                    if(j!= arr.length-1) sb.append(",");
                }

               sb.append("]\n");

            }
            finalList.add(sb.toString());

            return;
        }


if(!indices.contains(index)){
    indices.add(index);

    //Traversing in left direction
    calcWaysThruPuzzle(arr ,index - arr[index], indices, " " +str+ arr[index]+"L ", finalList );
    // Traversing in right direction
    calcWaysThruPuzzle(arr ,index + arr[index], indices, " " +str+ arr[index]+"R ", finalList );
    indices.remove(index);


}

    }
}
